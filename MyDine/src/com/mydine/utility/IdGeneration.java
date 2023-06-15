package com.mydine.utility;

public class IdGeneration {

	
	public static int generateId() {
		 
		return (int) (Math.random()*10000); 
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(generateId());
		
	}
}
