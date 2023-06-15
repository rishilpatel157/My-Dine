package com.mydine.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import com.mydine.entities.Customers;
import com.mydine.entities.ResOwners;
import com.mydine.entities.Restaurants;

public class FileExists {

	
	public static Map<Integer, Restaurants > restaurantFile(){
		
		Map<Integer, Restaurants > rFile = null;
		
		File f = new File("restaurants.ser");
		boolean flag = false;
		try {
			
			 if(!f.exists()) {
				 
				 f.createNewFile();
				 flag = true;
			 }
			 
			 if(flag) {
				 rFile = new LinkedHashMap<>();
				 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				 oos.writeObject(rFile);
				 return rFile;
			 }
			 else
			 {
				 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				 rFile = (Map<Integer,Restaurants>) ois.readObject();
				 return rFile;
			 }
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return rFile;
		
		
	}
	
	
	public static Map<String ,ResOwners > resOwners(){
		
		Map<String , ResOwners > ownersFile = null;
		
		
		return ownersFile;
	}
	
	public static Map<String,Customers> customerFile(){
		
		Map<String,Customers> cusFile = null;
		
		return cusFile;
	}
	
}
