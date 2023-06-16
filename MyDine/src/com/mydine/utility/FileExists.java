package com.mydine.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.mydine.entities.CustomerData;
=======
import java.util.LinkedHashMap;
import java.util.Map;

>>>>>>> 7203012ba1e02513b4c15bacad2c70b69e7b0a8b
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
		
<<<<<<< HEAD

=======
>>>>>>> 7203012ba1e02513b4c15bacad2c70b69e7b0a8b
		
	}
	
	
	public static Map<String ,ResOwners > resOwners(){
		
		Map<String , ResOwners > ownersFile = null;
		
		
		return ownersFile;
	}
	
	public static Map<String,Customers> customerFile(){
		
		Map<String,Customers> cusFile = null;
<<<<<<< HEAD
           
		 File f = new File("Customers.ser");
		 boolean flag = false;
		 try {
			
			 if(!f.exists())
			 {
				 f.createNewFile();
				 flag = true;
			 }
			 
			 if(flag) {
				 cusFile = new LinkedHashMap<>();
				 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				 oos.writeObject(cusFile);
				 return cusFile;
			 }
			 else
			 {
				 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				 cusFile = (Map<String,Customers>)ois.readObject();
				 return cusFile;
			 }
			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return cusFile;
	}

=======
		
		return cusFile;
	}
>>>>>>> 7203012ba1e02513b4c15bacad2c70b69e7b0a8b
	
}
