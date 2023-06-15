package com.mydine.servie;

import java.lang.module.ResolutionException;
import java.util.Map;

import com.mydine.entities.Restaurants;

public class RestaurantServiceImp implements RestaurantService{

	@Override
	public String addRestaraunts(Restaurants res, Map<Integer, Restaurants> restaurants) {

		Integer id = (int) res.getId();
		restaurants.put(id, res);
		System.out.println(restaurants.values());
		
		return " Restaurant added Successfully";
	}

	@Override
	public void viewAllRestarants( Map<Integer, Restaurants> restaurants) {
	
		
		   if(restaurants.size()>0)
		   {
			   for(Map.Entry<Integer, Restaurants> entry  : restaurants.entrySet())
			   {
				   System.out.println(entry.getValue());
			   }
		   }
		   else
		   {
			   throw new ResolutionException("Restaurant List is Empty");
		   }
	
	}
	

}
