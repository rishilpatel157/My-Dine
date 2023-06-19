package com.mydine.servie;

import java.io.Serializable;
import java.util.Map;

import com.mydine.entities.CustCart;
import com.mydine.entities.Restaurants;
import com.mydine.exceptions.InvalidDetailException;

public interface CustomerCartService extends Serializable{
  
	
	public String addTocart(Map<Integer ,Restaurants> resFile ,int key,String UserName,int menuKey,int qty,Map<String,CustCart> custCartFile);

     public void viewCustomerCart(String userName, Map<String , CustCart> custCartFile) throws InvalidDetailException;

}
