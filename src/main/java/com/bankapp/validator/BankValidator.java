package com.bankapp.validator;

import org.springframework.stereotype.Component;

import com.bankapp.exception.ValidationException;

@Component
public class BankValidator {

	/**
	 * This method used to validate bank details
	 * @param bankName
	 */
	public void validateAddBankDetails(String bankName) {
		if (bankName == null) {
			throw new ValidationException("Invalid Bank Name");
		}
		if(bankName.equals("")) {
			throw new ValidationException("Bank Name cannot be blank/empty");
		}
		
		//Bankname - only alphabets
		//bankname - ifsc => 20 digit
		
		
	}
}
