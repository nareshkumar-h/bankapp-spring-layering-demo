package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.BankDAO;
import com.bankapp.exception.DBException;
import com.bankapp.exception.ServiceException;
import com.bankapp.exception.ValidationException;
import com.bankapp.util.MailUtil;
import com.bankapp.validator.BankValidator;

@Service
public class BankService {

	@Autowired
	BankDAO bankDAO;// = new BankDAO();
	
	@Autowired
	BankValidator bankValidator;
	
	@Autowired
	MailUtil mailUtil;
	
	public void addBank(String bankName) throws ServiceException {
		
		//validation
//		if(bankName == null) {
//			throw new RuntimeException("Invalid Bank Name");
//		}
		
		try {
			bankValidator.validateAddBankDetails(bankName);
			
			//bankValidator.isExists(bankName);
			
			//Validation Passed
			bankDAO.addBank(bankName);
			
			//send mail
			mailUtil.sendMail("naresh@gmail.com", "Added Bank", "Successfully content");
			
			//smsUtil.sendSMS();
			
			//slackUtil.sendSlackMessage();
			
			
		} catch (ValidationException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getAllBanks() throws DBException{
		return bankDAO.getAllBanks();
	}
	
	public void deleteBank(String bankName) throws DBException {
		bankDAO.deleteBank(bankName);
	}
	
	
}
