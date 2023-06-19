package com.mydine.entities;

import java.io.Serializable;

public class Menu implements Serializable {

	private String item;
	private int cost;
	public Menu(String item, int cost) {
		super();
		this.item = item;
		this.cost = cost;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
	      
		return this.item+" "+ this.cost;
	}
}
