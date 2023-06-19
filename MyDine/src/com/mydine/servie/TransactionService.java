package com.mydine.servie;

import java.util.Map;

import com.mydine.entities.Transactions;
import com.mydine.exceptions.InvalidDetailException;

public interface TransactionService {

	public void viewTransaction(Map<String,Transactions> transFile,String userName) throws InvalidDetailException;
	
}
