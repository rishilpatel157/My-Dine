package com.mydine.entities;

import java.io.Serializable;

public class CustomerData implements Serializable {

	private String firstName;
	private String lastName;
	private String address;
	private long number;
	private String userName;
	private String password;
	private long wallet;
	public CustomerData(String firstName, String lastName, String address, long number, String userName,
			String password, long wallet) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.number = number;
		this.userName = userName;
		this.password = password;
		this.wallet = wallet;
	}
	







	public CustomerData() {
		super();
	}







	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getWallet() {
		return wallet;
	}
	public void setWallet(long wallet) {
		this.wallet = wallet;
	}
	
	
}
