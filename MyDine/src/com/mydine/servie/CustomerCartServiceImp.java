package com.mydine.servie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mydine.entities.CustCart;
import com.mydine.entities.Customers;
import com.mydine.entities.Dishes;
import com.mydine.entities.Restaurants;
import com.mydine.exceptions.InvalidDetailException;

public class CustomerCartServiceImp implements CustomerCartService,Serializable{


	@Override
	public String addTocart(Map<Integer, Restaurants> resFile,  int key, String UserName,
			int menuKey, int qty, Map<String, CustCart> custCartFile) {
		// TODO Auto-generated method stub
		try {
			
//      
	          
	           String resName = resFile.get(key).getResturantName();
	           String menuItem = resFile.get(key).getMenu().get(menuKey).getItem();
	           int menuCost = resFile.get(key).getMenu().get(menuKey).getCost();

	           Dishes dish = new Dishes(menuItem, menuCost, qty);
	           List<Dishes> dishes;

	           if (custCartFile.containsKey(UserName)) {
	               CustCart custCart = custCartFile.get(UserName);
	               Map<String, List<Dishes>> resNameMap = custCart.getResName();
	               
	               if (resNameMap.containsKey(resName)) {
	                   dishes = resNameMap.get(resName);
	               } else {
	                   dishes = new ArrayList<>();
	                   resNameMap.put(resName, dishes);
	               }
	           } else {
	               dishes = new ArrayList<>();
	               Map<String, List<Dishes>> resNameMap = new HashMap<>();
	               resNameMap.put(resName, dishes);
	               CustCart cart = new CustCart(menuItem, menuCost, qty, resNameMap, 0);
	               custCartFile.put(UserName, cart);
	           }

	           dishes.add(dish);

	           int total = 0;
	           for (Dishes i : dishes) {
	               total += i.getCost() * qty;
	           }

	           CustCart cart = custCartFile.get(UserName);
	           cart.setTotal(total);

	           
	           
	           
	           return "Successfully added to cart";
	           
	           
		} catch (Exception e) {
			// TODO: handle exception
	      System.out.println(e.getMessage());
		}
		return "Successfully added to cart";
		
	}

	@Override
	public void viewCustomerCart(String userName, Map<String, CustCart> custCartFile) throws InvalidDetailException {
		// TODO Auto-generated method stub
		if(custCartFile!=null && custCartFile.size()>0)
		{
			
			System.out.println(custCartFile.get(userName));
		}
		else
		{
			throw new InvalidDetailException("Cart is Empty");
		}
		
	}

	
	

}
