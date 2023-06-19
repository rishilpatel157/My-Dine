package com.mydine.servie;

import java.io.Serializable;
import java.util.Map;

import com.mydine.entities.Customers;
import com.mydine.exceptions.DuplicateDataException;
import com.mydine.exceptions.InvalidDetailException;

public class CustomerServiceImp implements CustomerService,Serializable{

	@Override
	public void signup(Customers cust, Map<String, Customers> cusFile) throws DuplicateDataException {
		
		     if(cusFile.containsKey(cust.getUserName()))
		     {
		    	throw new DuplicateDataException("User has already created");
		     }
		     else
		     {
		    	 
		    	 cusFile.put( cust.getUserName(), cust);
		    	System.out.println("Signup Successfully");
		     }
		     
		 
		
	}

	@Override
	public boolean login(String userName, String password, Map<String, Customers> custFile) throws InvalidDetailException {
		  
	    if(custFile.containsKey(userName))
	    {
	    
	    	  if(custFile.get(userName).getPassword().equals(password)) {
	    		  
	    		  return true;
	    		  
	    	  }
	    	  else
	    	  {
	    		  throw new InvalidDetailException("Invalid Credential");
	    	  }
	    	
	    }
	    else
	    {
	    	throw new InvalidDetailException("You have not Signup yet");
	    }
		
		
	}

	
	
}
