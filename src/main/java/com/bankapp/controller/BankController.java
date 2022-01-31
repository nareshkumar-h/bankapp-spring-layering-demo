package com.bankapp.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.exception.DBException;
import com.bankapp.exception.ServiceException;
import com.bankapp.service.BankService;

@RestController
@RequestMapping("api/banks")
public class BankController {

	BankService bankService = new BankService();
	
	@GetMapping
	public List<String> getAllBanks() {
		
		List<String> allBanks = null;
		try {
			allBanks = bankService.getAllBanks();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return allBanks;
	}
	
	
	
	@PostMapping
	public void addBank(@RequestBody String bankName) {
		try {
			bankService.addBank(bankName);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@DeleteMapping(":bankName")
	public void deleteBank(@PathVariable("bankName") String bankName) {
		try {
			bankService.deleteBank(bankName);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
