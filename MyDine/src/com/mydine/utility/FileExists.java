package com.mydine.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.mydine.entities.CustCart;
import com.mydine.entities.CustomerData;
import com.mydine.entities.Customers;
import com.mydine.entities.ResOwners;
import com.mydine.entities.Restaurants;
import com.mydine.entities.Transactions;

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

public static Map<String ,CustCart> custCartFile(){
	
	Map<String,CustCart> custCartFile = null;
    
	 File f = new File("CustomersCart1.ser");
	 boolean flag = false;
	 try {
		
		 if(!f.exists())
		 {
			 f.createNewFile();
			 flag = true;
		 }
		 
		if(flag) {
			 custCartFile = new LinkedHashMap<>();
			 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			 oos.writeObject(custCartFile);
			 return custCartFile;
		 }
		 else
		 {
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			 custCartFile = (Map<String,CustCart>)ois.readObject();
			 return custCartFile;
		 }
		 
		 
		 
		 
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getLocalizedMessage());
	}
	
	
	return custCartFile;
	
	
}


         public static Map<String,Transactions>  transactionFile(){
        	 
        	 Map<String,Transactions> TransactionFile = null;
        	    
        	 File f = new File("Transactions.ser");
        	 boolean flag = false;
        	 try {
        		
        		 if(!f.exists())
        		 {
        			 f.createNewFile();
        			 flag = true;
        		 }
        		 
        		if(flag) {
        			TransactionFile = new LinkedHashMap<>();
        			 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        			 oos.writeObject(TransactionFile);
        			 return TransactionFile;
        		 }
        		 else
        		 {
        			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        			 TransactionFile = (Map<String,Transactions>)ois.readObject();
        			 return TransactionFile;
        		 }
        		 
        		 
        		 
        		 
        	} catch (Exception e) {
        		// TODO: handle exception
        		System.out.println(e.getLocalizedMessage());
        	}
        	
        	
        	return TransactionFile;
        	 
         }
//
//public static void writeToFile(String filePath, String content) {
//    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//        writer.write(content);
//        System.out.println("File written successfully.");
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//
//
//public static String readFromFile(String filePath) {
//    StringBuilder content = new StringBuilder();
//
//    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//        String line;
//        while ((line = reader.readLine()) != null) {
//            content.append(line).append("\n");
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//
//    return content.toString();
//}
	
}
