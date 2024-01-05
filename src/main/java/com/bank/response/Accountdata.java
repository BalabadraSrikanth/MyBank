package com.bank.response;

public class Accountdata {
	private long acno;
	private String name;
	private String psw;
	private String cpsw;
	private double amount;
	private String address;
	private long mno;
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
		return "Accountdata [acno=" + acno + ", name=" + name + ", psw=" + psw + ", cpsw=" + cpsw + ", amount=" + amount
				+ ", address=" + address + ", mno=" + mno + "]";
	}

	
	
}
