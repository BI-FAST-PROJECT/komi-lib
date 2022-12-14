package bifast.library.iso20022.service;

import bifast.library.config.LibConfig;
import bifast.library.iso20022.custom.BusinessMessage;
import bifast.library.iso20022.prxy006.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


@Service
public class Proxy006MessageService {
	
	@Autowired
	private LibConfig config;
	
	public ProxyEnquiryResponseV01 proxyRegistrationInquiryResponse (Proxy006Seed seed, 
			BusinessMessage orgnlMessage) 
			throws DatatypeConfigurationException {
		
		
		//Response
		ProxyEnquiryResponseV01 response = new ProxyEnquiryResponseV01();
		
		GroupHeader60 grpHdr = new GroupHeader60();
		grpHdr.setMsgId(seed.getMsgId());
		
		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		grpHdr.setCreDtTm(xcal);
		
		// GrpHdr / MsgSndr / Agt/ FinInstnId/ Othr /Id
		GenericFinancialIdentification1 sndrId = new GenericFinancialIdentification1();
		sndrId.setId(config.getBankcode());
		FinancialInstitutionIdentification8 finInstnId = new FinancialInstitutionIdentification8();
		finInstnId.setOthr(sndrId);
		
		BranchAndFinancialInstitutionIdentification5 sndrAgt = new BranchAndFinancialInstitutionIdentification5();
		sndrAgt.setFinInstnId(finInstnId);
		
		Party12Choice msgSndr = new Party12Choice();
		msgSndr.setAgt(sndrAgt);
		
		grpHdr.setMsgRcpt(msgSndr);
		response.setGrpHdr(grpHdr);	
		
		//OrgnlGrpInf
		OriginalGroupInformation3 OrgnlGrpInf =  new OriginalGroupInformation3();
		OrgnlGrpInf.setOrgnlMsgId(seed.getOrgnlMsgId());
		OrgnlGrpInf.setOrgnlCreDtTm(seed.getOrgnlCreDtTm());
		OrgnlGrpInf.setOrgnlMsgNmId(seed.getOrgnlMsgNmId());
		response.setOrgnlGrpInf(OrgnlGrpInf);
		
		ProxyEnquiryResponse1 nqryRspn = new ProxyEnquiryResponse1();
				  
		if(seed.getStatus().equals("ACTC")) {
			nqryRspn.setPrxRspnSts(ProxyStatusCode.ACTC);
		}else {
			nqryRspn.setPrxRspnSts(ProxyStatusCode.RJCT);
		}
		
		ProxyStatusChoice StsRsnInf = new ProxyStatusChoice();
		StsRsnInf.setPrtry(seed.getReason());
		nqryRspn.setStsRsnInf(StsRsnInf);
		
		 if(seed.getProxy006SeedAccountList() != null ) {
			 List<ProxyEnquiryInformation1> Rspn = new ArrayList<ProxyEnquiryInformation1>();
			 
			 for(Proxy006SeedAccount data:seed.getProxy006SeedAccountList()) {
				 ProxyEnquiryInformation1 proxyEnquiryInformation1 = new ProxyEnquiryInformation1();
					
					proxyEnquiryInformation1.setDsplNm(data.getDisplayName());
					proxyEnquiryInformation1.setRegnId(data.getRegnId());
					
					GenericFinancialIdentification1 othrRegnRspn = new GenericFinancialIdentification1();
					othrRegnRspn.setId(data.getRegisterBank());
					
					FinancialInstitutionIdentification8 finInstnIdRegnRspn = new FinancialInstitutionIdentification8();
					finInstnIdRegnRspn.setOthr(othrRegnRspn);
					
					BranchAndFinancialInstitutionIdentification5 agtRegnRspn = new BranchAndFinancialInstitutionIdentification5();
					agtRegnRspn.setFinInstnId(finInstnIdRegnRspn);
					proxyEnquiryInformation1.setPtcpt(agtRegnRspn);
					
					ProxyEnquiryDefinition1 prxyInf = new ProxyEnquiryDefinition1();
					prxyInf.setSts(data.getAccountStatus());
					prxyInf.setTp(data.getPrxyInfTp());
					prxyInf.setVal(data.getPrxyInfVal());
					proxyEnquiryInformation1.setPrxyInf(prxyInf);
					
					ProxyEnquiryAccount1 AcctInf = new ProxyEnquiryAccount1();
					
					GenericFinancialIdentification1 othr = new GenericFinancialIdentification1();
					othr.setId(data.getRegisterBank());
					
					FinancialInstitutionIdentification8 finInstnId1 = new FinancialInstitutionIdentification8();
					finInstnId1.setOthr(othr);
					
					BranchAndFinancialInstitutionIdentification5 agt = new BranchAndFinancialInstitutionIdentification5();
					agt.setFinInstnId(finInstnId1);
					AcctInf.setAgt(agt);
					
					GenericAccountIdentification1 othr1 = new GenericAccountIdentification1();
					othr1.setId(data.getAccountNumber());
					
					AccountIdentification4Choice id = new AccountIdentification4Choice();
					id.setOthr(othr1);
					
					CashAccountType2ChoiceProxy tp = new CashAccountType2ChoiceProxy();
					tp.setPrtry(data.getAccountType());
					
					CashAccount40 cashAccount40 =  new CashAccount40();
					cashAccount40.setId(id);
					
					cashAccount40.setTp(tp);
					cashAccount40.setNm(data.getAccountName());
					
					AcctInf.setAcct(cashAccount40);


					BIAddtlCstmrInf bIAddtlCstmrInf = new BIAddtlCstmrInf();
					bIAddtlCstmrInf.setId(data.getCstmrId());
					bIAddtlCstmrInf.setTp(data.getCstmrTp());
					bIAddtlCstmrInf.setTwnNm(data.getCstmrTwnNm());
					bIAddtlCstmrInf.setRsdntSts(data.getCstmrRsdntSts());
					
					///
					BISupplementaryDataEnvelope1 biSupplementaryDataEnvelope1 =  new BISupplementaryDataEnvelope1();
					biSupplementaryDataEnvelope1.setDtl(new BISupplementaryDetail1 ());
					//biSupplementaryDataEnvelope1.setCstmr(bIAddtlCstmrInf);

					///
					BISupplementaryData1 biSupplementaryData1 = new BISupplementaryData1();
					biSupplementaryData1.setEnvlp(biSupplementaryDataEnvelope1);
					///
					//proxyEnquiryInformation1.getSplmtryData().add(new BISupplementaryData1());
					//proxyEnquiryInformation1.getSplmtryData().setEnvlp(biSupplementaryDataEnvelope1);
					proxyEnquiryInformation1.setAcctInf(AcctInf);
					Rspn.add(proxyEnquiryInformation1);
			 }
			 
			nqryRspn.getRspn().addAll(Rspn);
		 }
		response.setNqryRspn(nqryRspn);
		
		return response;
	}

}
