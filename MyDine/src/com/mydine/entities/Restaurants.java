package com.mydine.entities;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Map;

public class Restaurants implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private  String resturantName;
	private String address;
	private String cuisineType;
	private LocalTime openTime;
	private LocalTime closeTime;
	private int menuItemNo;
	
	private Map<Integer,Menu> menu;
	
	
	
	public Restaurants() {
		super();
	}



	public Restaurants(int id, String resturantName, String address, String cuisineType, LocalTime openTime,
			LocalTime closeTime, int menuItemNo, Map<Integer, Menu> menu) {
		super();
		this.id = id;
		this.resturantName = resturantName;
		this.address = address;
		this.cuisineType = cuisineType;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.menuItemNo = menuItemNo;
		this.menu = menu;
	}



	public String getResturantName() {
		return resturantName;
	}



	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
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
	
		String str = " Resturant id = "+id+ " menu"+menu+"";
		
		
		return str;
	}


	
	
	
	
}
