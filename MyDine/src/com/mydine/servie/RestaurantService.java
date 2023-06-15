package com.mydine.servie;

import java.util.Map;

import com.mydine.entities.Restaurants;

public interface RestaurantService {

	public  String addRestaraunts(Restaurants res, Map<Integer,Restaurants> restaurants );
	
	public void viewAllRestarants(Map<Integer,Restaurants> restaurants );
}
