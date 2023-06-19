package com.mydine.servie;

import java.util.List;
import java.util.Map;

import com.mydine.entities.CustCart;
import com.mydine.entities.Transactions;
import com.mydine.exceptions.InvalidDetailException;

public class TransactionFileImp implements TransactionService{

	@Override
	public void viewTransaction(Map<String, Transactions> transFile, String userName) throws InvalidDetailException {
		// TODO Auto-generated method stub
		if(transFile!=null && transFile.size()>0)
		{
			
		Transactions trans = transFile.get(userName);
		
		try {

			if(trans!= null ) {
				
				int hour = trans.getTime().getHour();
				int minute = trans.getTime().getMinute();
				System.out.println("Order Placed on "+trans.getDate()+" at "+hour+":"+minute);
				Map<String, CustCart>  cart = trans.getCart();
				
			
				        System.out.println(cart.get(userName));
				
 				System.out.println("Total Amount is : "+cart.get(userName).getTotal());
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		}
		
		else
		{
		  throw new InvalidDetailException("Transactions has not been made yet");	
		}
			
			
			
		
	}

}
