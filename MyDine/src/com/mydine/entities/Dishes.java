package com.mydine.entities;

import java.io.Serializable;

public class Dishes extends Menu implements Serializable{

	
	private int qty;


	public Dishes(String item, int cost, int qty) {
		super(item, cost);
		this.qty = qty;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}
	
	 @Override
	    public String toString() {
	        return " " +
	                " Dish : " + getItem() + ","+
	                " cost :" + getCost() +","+
	                " qty :" + qty +
	                ". \n";
	    }
	
	
}
