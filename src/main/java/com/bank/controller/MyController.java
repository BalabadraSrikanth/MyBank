package com.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bank.Entity.OpenAccount;
import com.bank.repo.RegisterRepo;
import com.bank.service.OpenAccountImpl;

@RestController
@EnableWebMvc
public class MyController {
	@Autowired
	public OpenAccountImpl service;
	@Autowired
	public RegisterRepo repo;

	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
	
	
// OPEN ACCOUNT
	
	@PostMapping("/openacc")
	public String first(@RequestBody OpenAccount open) {
		 service.openaccount(open);
		 return "account Open With "+"\n"+"acno:-"+open.getAcno()+"\n Name:- "+open.getName()+"\n Address:- "+open.getAddress()+
				 "\n Mobile:- "+open.getMno()+"\n Amount:-"+open.getAmount()+"\n Successfully ";
	}
	
	
//CHECK BALANCE	
	@GetMapping("/balance/{acno}")
	public String accBalance(@PathVariable("acno") Long acno) {
	    Optional<OpenAccount> account = repo.findById(acno);
	    if (account.isPresent()) {
	        Double balance = service.getBalance(acno);
	        if (balance != null) {
	            String bal = String.valueOf(balance);
	            return "Your Balance is " + bal;
	        } else {
	            return "No Balance Found";
	        }
	    } else {
	        return "No Account Found";
	    }
	}

//GET ALL ACCOUNT DETAILS
	@GetMapping("/accdetails")
	public List<OpenAccount> getDetails() {
		return service.getAccDetalis();
	}
	
	
//GET ACOUNT DETAILS USING ACC NO.	
	@GetMapping("/accdetails/{acno}")
	public OpenAccount getaccDetails(@PathVariable long acno) {
		return service.getAccDetails(acno);
	}
	
//DEPOSIT AMOUNT
	@PostMapping("/deposit/{acno}/{amount}")
	public String deposit(@RequestAttribute @PathVariable("acno")Long acno,@PathVariable("amount") Double amount,  OpenAccount open) {
		
		service.depostBalance(open,amount,acno);
		return "Successfully Depositer";
		
	}
	
//WITHDRAW AMOUNT
		@PostMapping("/withdraw/{acno}/{amount}")
		public String withdraw(@RequestAttribute @PathVariable("acno") Long acno,@PathVariable("amount") Double amount,OpenAccount open) {
			if(service.withdrawAmount(open, amount, acno)==0) {
				return "No Sufficent Balance";
			}
			
			return "Withdrawed Sucessfully";
		}
	
	
//ACCOUNT STATUS OPEN/CLOSED
		@PostMapping("/status/{acno}/{status}")
		public String status(@RequestAttribute @PathVariable("acno") Long acno, @PathVariable("status") String status ,OpenAccount open) {
			return service.status(open, status, acno);
		}
	
//TRANSFER AMOUNT
		@PostMapping("/transfer/{acno}/{amount}/{tacno}")
		public String transferAmt(@RequestAttribute @PathVariable("acno") Long acno,@PathVariable("amount") Double amount,@PathVariable("tacno") Long tacno, OpenAccount open) {
			return service.transferAmt(open, acno, tacno, amount);
		}

}
