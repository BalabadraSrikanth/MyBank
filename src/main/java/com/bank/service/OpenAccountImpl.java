package com.bank.service; 

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Entity.OpenAccount;
import com.bank.repo.RegisterRepo;
@Service
public class OpenAccountImpl implements OpenAccountService{
	@Autowired
	public RegisterRepo repo;
	

	@Override
	public OpenAccount openaccount(OpenAccount openac) {
		long acno;
		long min=10000000000l;
		long max=99999999999l;
		Random r=new Random();
		acno=r.nextLong(((max-min)+1)+min);
		openac.setAcno(acno);
		
		return repo.save(openac);
	}
	@Override
	 public Double getBalance(Long acno) {
	        return repo.findBalanceByAccountNumber(acno);
	    }
	
	

	@Override
	public List<OpenAccount> getAccDetalis() {
		return repo.findAll();
	}

	@Override
	public OpenAccount getAccDetails(long acno) {
		//if(repo.findById(acno).isPresent()) 
		
			return repo.findById(acno).get();
			
		}
	@Override
	public Double depostBalance(OpenAccount open,Double amount,Long acno) {
		double amt=repo.findBalanceByAccountNumber(acno);
		amount+=amt;
		repo.updateAmount(acno,amount);
		
		return amount;
	}
	@Override
	public Double withdrawAmount(OpenAccount open, Double amount, Long acno) {
			double amt=repo.findBalanceByAccountNumber(acno);
			amt-=amount;
			if(amt<0) {
				return (double) 0;
			}
			repo.updateAmount(acno, amt);
			return (double) 1;
	}
	@Override
	public String status(OpenAccount open, String status, Long acno) {
		
		
		repo.updateStatus(acno, status);
		return "status changed";
	}
	@Override
	public String transferAmt(OpenAccount open, Long acno, Long tacno, Double amount) {
		if(repo.checkStatus(tacno).equals("closed")) {
			return "Reciver account was unable to identify";
		}
		if(repo.checkStatus(acno).equals("closed")) {
			return "Senders account was unable to identify";
		}
		if(withdrawAmount(open, amount, acno)!=0) {
			depostBalance(open, amount, tacno);
			return "funds Transfured";
		}
		
		return "No sufficient Balance";
		
		
	}

}
