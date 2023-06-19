package com.mydine.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustCart extends Dishes implements Serializable{

	
	private Map<String, List<Dishes> > resName;
	
	
	
	private int total;

	
	

	 public CustCart(String item, int cost, int qty, Map<String, List<Dishes>> resName, int total) {
		super(item, cost, qty);
		this.resName = resName;
		this.total = total;
	}




	public Map<String, List<Dishes>> getResName() {
		return resName;
	}




	public void setResName(Map<String, List<Dishes>> resName) {
		this.resName = resName;
	}




	public int getTotal() {
		return total;
	}




	public void setTotal(int total) {
		this.total = total;
	}




	public String toString() {
		int total1 = 0;
	        StringBuilder stringBuilder = new StringBuilder();
	        stringBuilder.append("Customer Cart : ").append("\n");
	        for(Map.Entry<String,List<Dishes>> i : resName.entrySet())
	        {
	        	int total2=0;
	        	stringBuilder.append("Restuarant Name : ").append(i.getKey()).append('\n');
	        	for(Dishes j : i.getValue())
	        	{  
//	        		stringBuilder.append(" dishes : ").append("\n");
	        	
	        		stringBuilder.append(j);
	        		total1+=j.getCost()*j.getQty();
	        		total2+=j.getCost()*j.getQty();
	        	}
	        	
	        	stringBuilder.append(i.getKey()+" Total is : "+total2).append("\n");
	        	
	        }
	        	
	        stringBuilder.append(",Final total Cost :").append(total1).append("\n");
//	        stringBuilder.append('');
	        this.total = total1;
	        return stringBuilder.toString();
	    }
}
