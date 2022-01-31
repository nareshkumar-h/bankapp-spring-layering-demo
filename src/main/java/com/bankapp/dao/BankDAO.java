package com.bankapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bankapp.exception.DBException;

@Repository
public class BankDAO {

	static List<String> banks = new ArrayList<>();

	public void addBank(String bankName) throws DBException {
		try {
			banks.add(bankName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Unable to add bank details to db", e);
		}
	}

	public List<String> getAllBanks() throws DBException {
		return banks;
	}

	public void deleteBank(String bankName) throws DBException {
		banks.remove(bankName);
	}
}
