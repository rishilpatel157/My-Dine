package com.mydine.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Transactions implements Serializable{

	
	private String userName;

	private String custName;
	
	private long number;
	
	private Map<String, CustCart> custFile;
	
	
	private LocalDate date;
	
	private LocalTime time;

	public Transactions(String userName, String custName, long number, Map<String, CustCart>  cart, LocalDate date,
			LocalTime time) {
		super();
		this.userName = userName;
		this.custName = custName;
		this.number = number;
		this.custFile = cart;
		this.date = date;
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public Map<String, CustCart>  getCart() {
		return custFile;
	}

	public void setCart(Map<String, CustCart>  cart) {
		this.custFile = cart;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	  @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Transaction details:\n");
	        sb.append("Username: ").append(userName).append("\n");
	        sb.append("Customer Name: ").append(custName).append("\n");
	        sb.append("Number: ").append(number).append("\n");
	        sb.append(custFile.values()).append("\n");
	        sb.append("Date: ").append(date).append("\n");
	        sb.append("Time: ").append(time).append("\n");
	        return sb.toString();
	    }
	
	
	
	
	
}
