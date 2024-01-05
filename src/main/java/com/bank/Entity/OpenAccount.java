package com.bank.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class OpenAccount {

	@Id
	@Column(name = "accountnumber")
	private long acno;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String psw;
	@Transient
	private String cpsw;
	@Column(name = "amount")
	private double amount;
	@Column(name = "address")
	private String address;
	@Column(name = "mobilenumber")
	private long mno;
	@Column(name="status")
	private String status;
	public OpenAccount() {
		super();
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OpenAccount(long acno, String name, String psw, String cpsw, double amount, String address, long mno,
			String status) {
		super();
		this.acno = acno;
		this.name = name;
		this.psw = psw;
		this.cpsw = cpsw;
		this.amount = amount;
		this.address = address;
		this.mno = mno;
		this.status = status;
	}
	public long getAcno() {
		return acno;
	}
	public void setAcno(long acno) {
		this.acno = acno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getCpsw() {
		return cpsw;
	}
	public void setCpsw(String cpsw) {
		this.cpsw = cpsw;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMno() {
		return mno;
	}
	public void setMno(long mno) {
		this.mno = mno;
	}
	@Override
	public String toString() {
		return "OpenAccount [acno=" + acno + ", name=" + name + ", psw=" + psw + ", cpsw=" + cpsw + ", amount=" + amount
				+ ", address=" + address + ", mno=" + mno + ", status=" + status + "]";
	}
	
	
	
}
