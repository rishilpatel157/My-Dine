package com.mydine.servie;

import java.util.Map;

import com.mydine.entities.Restaurants;
<<<<<<< HEAD
import com.mydine.exceptions.RestuarantException;
=======
>>>>>>> 7203012ba1e02513b4c15bacad2c70b69e7b0a8b

public interface RestaurantService {

	public  String addRestaraunts(Restaurants res, Map<Integer,Restaurants> restaurants );
	
<<<<<<< HEAD
	public void viewAllRestarants(Map<Integer,Restaurants> restaurants ) throws RestuarantException;
	
	public  void deleteRestaurant(int id,Map<Integer,Restaurants> resFile) throws RestuarantException;
	
	
	public  String updateRestaurant(Integer id,Restaurants restaurant, Map<Integer,Restaurants> resFile) throws RestuarantException;
=======
	public void viewAllRestarants(Map<Integer,Restaurants> restaurants );
>>>>>>> 7203012ba1e02513b4c15bacad2c70b69e7b0a8b
}
