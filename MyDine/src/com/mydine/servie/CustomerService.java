package com.mydine.servie;

import java.util.Map;

import com.mydine.entities.Customers;
import com.mydine.exceptions.DuplicateDataException;
import com.mydine.exceptions.InvalidDetailException;

public interface CustomerService {

	public boolean login(String userName,String password,Map<String,Customers> custFile) throws InvalidDetailException;
	
	public void signup(Customers cust,Map<String,Customers> cusFile) throws DuplicateDataException;
	
	
	
}
