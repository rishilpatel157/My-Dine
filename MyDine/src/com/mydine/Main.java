package com.mydine;

import java.text.DateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.mydine.entities.Customers;
import com.mydine.entities.Menu;
import com.mydine.entities.ResOwners;
import com.mydine.entities.Restaurants;
import com.mydine.exceptions.InvalidDetailException;
import com.mydine.servie.RestaurantService;
import com.mydine.servie.RestaurantServiceImp;
import com.mydine.utility.FileExists;
import com.mydine.utility.IdGeneration;

public class Main {

	
	
          private static void adminFunctionality(Scanner sc , Map<Integer,Restaurants> resturants) throws InvalidDetailException {
	 
	       adminLogin(sc);
	       RestaurantService resService = new RestaurantServiceImp(); 
	     
	       int choice = 0;
	     
	       try {
            do {
        	  
        	  System.out.println("'1' ---> View All Restuarants.");
        	  System.out.println("'2' ---> Add Restaurants");
        	  choice = sc.nextInt();
        	 switch (choice) {
			case 1:
			       
				resService.viewAllRestarants(resturants);
				break;
			case 2:
				addRestaurants(resturants, resService);	 
			       break;
        	 }
        	  
          }while(choice!=0);
          
	    	 
	    	 
	    	 
		} catch (Exception e) {
			// TODO: handle exception
 		}
      }
          
       public static void addRestaurants(Map<Integer, Restaurants > restaurants,RestaurantService resService){
        Scanner sc = new Scanner(System.in);
    	   
    	   System.out.println("Enter Restaurants Details");
    	   System.out.println("Enter Restaurant Name");
    	   String resName = sc.nextLine();
    	   System.out.println("Enter Restuarant Address");
    	   String resAddress = sc.nextLine();
    	   System.out.println("Enter Cuisine of your Restaurant");
    	   String resCuisine = sc.nextLine();
    	   System.out.println("Enter Restaurant Opening Time");
    	   String resOpenTime = sc.next();
    	   System.out.println("Enter Restaurant Closing Time");
    	   String resCloseTime = sc.next();
    	   System.out.println("Enter number of items do you want to add in your MENU");
    	   int menuNum = sc.nextInt();
    	    Map<Integer,Menu> map = new HashMap<>();
//    	    Map<Integer , Map<String,Integer>> menu = new HashMap<>();
    	    
    	   for(int i = 0;i<menuNum;i++)
    	   {
    		   Scanner sc1 = new Scanner(System.in);
    		   
    		   System.out.println("Enter Dish Name");
               String Men = sc1.nextLine();
               System.out.println("Enter cost of dish");
                int cost = sc1.nextInt();
                 Integer id = i+1;
                Menu item = new Menu(Men, cost);                 
                map.put(id, item);  
                }
    	   
    	   
    	   
    	    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
    	    LocalTime openTime = LocalTime.parse(resOpenTime,format);
    	    LocalTime closeTime = LocalTime.parse(resCloseTime,format);
    	    
    	   
    	   
    	   Restaurants  restaurant1 = new Restaurants(IdGeneration.generateId(), resName, resAddress, resCuisine, openTime, closeTime, menuNum, map);
    	         resService.addRestaraunts(restaurant1, restaurants);    	   
    	 
          }
 
 
 public static void adminLogin(Scanner sc) throws InvalidDetailException{
	 
	 System.out.println("Please enter your user name");
	 String username = sc.next();
	 System.out.println("Please enter your password");
	 String password = sc.next();
	 
	 if(username.equals("admin") && password.equals("12345")) {
		 System.out.println("Successfully Logged in");
	 }
	 else
	 {
		 throw new InvalidDetailException("Invalid Admin Credentails");
	 }
	 
	 
	 
	 
 }
	
	public static void main(String[] args) {
		
		Map<Integer, Restaurants> restaurants = FileExists.restaurantFile();
        Map< String ,ResOwners>	resOwners = FileExists.resOwners();
        Map<String , Customers > customers = FileExists.customerFile();
		
        
        
        System.out.println(restaurants);
        for (Map.Entry<Integer, Restaurants> entry : restaurants.entrySet()) {
            int key = entry.getKey();
            Restaurants restaurant = entry.getValue();
            System.out.println("Key: " + key);
            System.out.println("Restaurant: " + restaurant);
            // Print other specific properties of the Restaurants object if needed
            // For example: System.out.println("Name: " + restaurant.getName());
            //              System.out.println("Address: " + restaurant.getAddress());
            System.out.println("-------------------------");
        }

		
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Welcome, in MyDine Resturant.");
		
		try {
			
			int choice = 0;
			
			do {
				
				System.out.println("Please enter your Prefernce.");
				System.out.println("'1' ---> Admin Login.");
				System.out.println("'2' ---> Resturantant Owner.");
				System.out.println("'3' ---> Customer Login.");
				System.out.println("'4' ---> Customer Signup.");
				System.out.println("'0' ---> for exit.");
						choice = sc.nextInt();
				switch (choice) {
				
				case 1: {
					
					adminFunctionality(sc , restaurants);
					
					
					
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}		
						
			}while(choice!=0);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
   
	
}
