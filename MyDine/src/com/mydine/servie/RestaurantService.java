package com.mydine.servie;

import java.io.Serializable;
import java.util.Map;

import com.mydine.entities.Restaurants;
import com.mydine.exceptions.RestuarantException;

public interface RestaurantService extends Serializable {

	public  String addRestaraunts(Restaurants res, Map<Integer,Restaurants> restaurants );
	
	public void viewAllRestarants(Map<Integer,Restaurants> restaurants ) throws RestuarantException;
	
	public  void deleteRestaurant(int id,Map<Integer,Restaurants> resFile) throws RestuarantException;
	
	public void viewSelectedRes(int id,Map<Integer ,Restaurants> resFile);
	
	public void viewMenu(int key,Map<Integer,Restaurants> resFile);
	
	
	public  String updateRestaurant(Integer id,Restaurants restaurant, Map<Integer,Restaurants> resFile) throws RestuarantException;
}
