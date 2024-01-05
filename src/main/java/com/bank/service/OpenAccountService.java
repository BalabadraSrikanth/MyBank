package com.bank.service;

import java.util.List;


import com.bank.Entity.OpenAccount;



public interface OpenAccountService {
	public OpenAccount openaccount(OpenAccount openac);
	public Double getBalance(Long acno);
	public OpenAccount getAccDetails(long acno);
	public List<OpenAccount> getAccDetalis();
	public Double depostBalance(OpenAccount oprn,Double amount,Long acno);
	public Double withdrawAmount(OpenAccount open,Double amount,Long acno);
	public String status(OpenAccount open,String status,Long acno);
	public String transferAmt(OpenAccount open,Long acno,Long tacno,Double amount);
}
