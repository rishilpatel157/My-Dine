package com.mydine.servie;

import java.lang.module.ResolutionException;
import java.util.Map;

import com.mydine.entities.Restaurants;
import com.mydine.exceptions.RestuarantException;

public class RestaurantServiceImp implements RestaurantService{

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
		// TODO Auto-generated method stub
		
			
    		resFile.put(id,restaurant);
//    		throw new RestuarantException("Sucessfully Updated");
    		
    		return "SucessFull Updated";
    	
	}
	

}
