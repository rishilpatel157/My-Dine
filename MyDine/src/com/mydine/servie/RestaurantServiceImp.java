package com.mydine.servie;

import java.io.Serializable;
import java.util.Map;

import com.mydine.entities.Menu;
import com.mydine.entities.Restaurants;
import com.mydine.exceptions.RestuarantException;

public class RestaurantServiceImp implements RestaurantService,Serializable{

	@Override
	public String addRestaraunts(Restaurants res, Map<Integer, Restaurants> restaurants) {

		Integer id = (int) res.getId();
		restaurants.put(id, res);
		
		return " Restaurant added Successfully";
	}

	@Override
	public void viewAllRestarants( Map<Integer, Restaurants> restaurants) throws RestuarantException {
	
		   if(restaurants!=null && restaurants.size()>0)
		   {
			   for(Map.Entry<Integer, Restaurants> entry  : restaurants.entrySet())
			   {
				   
				   System.out.println(entry.getValue());
			   }
		   }
		   else
		   {
			   throw new RestuarantException("Restaurant List is Empty");
		   }
	
	}

	@Override
	public void deleteRestaurant(int id, Map<Integer, Restaurants> resFile) throws RestuarantException{
		// TODO Auto-generated method stub
		         Integer id1 = id;
		     
		        	if(resFile.containsKey(id1))
		        	{
		        		
		        		resFile.remove(id1);
		        		throw new RestuarantException("Sucessfully Deleted");
		        	}
		        	else
		        	{
		        		throw new RestuarantException("ID is Invalid");
		        	}
		      
		
	}

	@Override
	public String updateRestaurant(Integer id,Restaurants restaurant, Map<Integer, Restaurants> resFile) throws RestuarantException {
		
			
    		resFile.put(id,restaurant);
//    		throw new RestuarantException("Sucessfully Updated");
    		
    		return "SucessFull Updated";
    	
	}

	@Override
	public void viewSelectedRes(int id, Map<Integer, Restaurants> resFile) {
	
	     System.out.println(resFile.get(id));
		
	}

	@Override
	public void viewMenu(int key, Map<Integer, Restaurants> resFile) {
		
//		System.out.println(resFile.get(key).getMenu().keySet());
		  Map<Integer,Menu> menu  = resFile.get(key).getMenu();
		StringBuilder sb = new StringBuilder();
		
		 for (Map.Entry<Integer, Menu> entry : menu.entrySet()) {
		        int menuItemId = entry.getKey();
		        Menu menuItem = entry.getValue();
		        sb.append("Menu id : "+menuItemId).append(" - ");
		        sb.append(menuItem.getItem()+" Rs : "+menuItem.getCost()).append("\n");
		    }
		 System.out.println(sb.toString());
		
	}
	

}
