package com.mydine.entities;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Map;
<<<<<<< HEAD
import java.util.Objects;

public class Restaurants implements Serializable{
 
	private int id;
	private  String restaurantName;
=======

public class Restaurants implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private  String resturantName;
>>>>>>> 7203012ba1e02513b4c15bacad2c70b69e7b0a8b
	private String address;
	private String cuisineType;
	private LocalTime openTime;
	private LocalTime closeTime;
	private int menuItemNo;
<<<<<<< HEAD
	private String resOwnerUserName;
=======
	
>>>>>>> 7203012ba1e02513b4c15bacad2c70b69e7b0a8b
	private Map<Integer,Menu> menu;
	
	
	
	public Restaurants() {
		super();
	}



<<<<<<< HEAD
	public Restaurants(int id, String restaurantName,String resOwnerUserName, String address, String cuisineType, LocalTime openTime,
			LocalTime closeTime, int menuItemNo, Map<Integer, Menu> menu) {
		super();
		this.id = id;
		this.resOwnerUserName = resOwnerUserName;
		this.restaurantName = restaurantName;
=======
	public Restaurants(int id, String resturantName, String address, String cuisineType, LocalTime openTime,
			LocalTime closeTime, int menuItemNo, Map<Integer, Menu> menu) {
		super();
		this.id = id;
		this.resturantName = resturantName;
>>>>>>> 7203012ba1e02513b4c15bacad2c70b69e7b0a8b
		this.address = address;
		this.cuisineType = cuisineType;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.menuItemNo = menuItemNo;
		this.menu = menu;
	}



<<<<<<< HEAD
	public String getResOwnerUserName() {
		return resOwnerUserName;
	}



	public void setResOwnerUserName(String resOwnerUserName) {
		this.resOwnerUserName = resOwnerUserName;
	}



	public String getResturantName() {
		return restaurantName;
=======
	public String getResturantName() {
		return resturantName;
>>>>>>> 7203012ba1e02513b4c15bacad2c70b69e7b0a8b
	}



	public void setResturantName(String resturantName) {
<<<<<<< HEAD
		this.restaurantName = resturantName;
=======
		this.resturantName = resturantName;
>>>>>>> 7203012ba1e02513b4c15bacad2c70b69e7b0a8b
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCuisineType() {
		return cuisineType;
	}



	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}



	public LocalTime getOpenTime() {
		return openTime;
	}



	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}



	public LocalTime getCloseTime() {
		return closeTime;
	}



	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}



	public int getMenuItemNo() {
		return menuItemNo;
	}



	public void setMenuItemNo(int menuItemNo) {
		this.menuItemNo = menuItemNo;
	}



	public Map<Integer, Menu> getMenu() {
		return menu;
	}



	public void setMenu(Map<Integer, Menu> menu) {
		this.menu = menu;
	}



	public long getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
<<<<<<< HEAD
		
	    StringBuilder sb = new StringBuilder();
	    sb.append("Restaurant ID: ").append(id).append("\n");
	    sb.append("Restaurant Name: ").append(restaurantName.toUpperCase()).append("\n");
	    sb.append("Address: ").append(address).append("\n");
	    sb.append("Cuisine Type: ").append(cuisineType).append("\n");
	    sb.append("Opening Time: ").append(openTime).append(" ");
	    sb.append("Closing Time: ").append(closeTime).append("\n");
	    sb.append("Menu:").append("\n");
	    
	    for (Map.Entry<Integer, Menu> entry : menu.entrySet()) {
	        int menuItemId = entry.getKey();
	        Menu menuItem = entry.getValue();
	        sb.append(menuItemId).append(" - ");
	        sb.append(menuItem.toString()).append("\n");
	    }
	    
	    return sb.toString();
	}



		
	

=======
	
		String str = " Resturant id = "+id+ " menu"+menu+"";
		
		
		return str;
	}
>>>>>>> 7203012ba1e02513b4c15bacad2c70b69e7b0a8b


	
	
	
	
}
