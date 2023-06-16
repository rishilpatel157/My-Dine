package com.mydine;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.mydine.entities.CustomerData;
import com.mydine.entities.Customers;
import com.mydine.entities.Menu;
import com.mydine.entities.ResOwners;
import com.mydine.entities.Restaurants;
import com.mydine.exceptions.DuplicateDataException;
import com.mydine.exceptions.InvalidDetailException;
import com.mydine.exceptions.RestuarantException;
import com.mydine.servie.CustomerService;
import com.mydine.servie.CustomerServiceImp;
import com.mydine.servie.RestaurantService;
import com.mydine.servie.RestaurantServiceImp;
import com.mydine.utility.FileExists;
import com.mydine.utility.IdGeneration;

public class Main {

	
	
          private static void adminFunctionality(Scanner sc , Map<Integer,Restaurants> restaurants) throws InvalidDetailException {
	 
        	  try {
	       adminLogin(sc);
	       RestaurantService resService = new RestaurantServiceImp(); 
	     
	       int choice = 0;
	     do {
            	 
            try {
            	
				
        	     System.out.println("'1' ---> View All Restuarants.");
        	     System.out.println("'2' ---> Add Restaurants");
        	     System.out.println("'3' ---> Delete Restaurant");
        	     System.out.println("'4' ---> Update Restaurant Details");
        	     choice = sc.nextInt();
        	 switch (choice) {
			   case 1:
			        resService.viewAllRestarants(restaurants);
			    	break;
		    	case 2:
		    		addRestaurants(restaurants, resService);	 
			        break;
		    	case 3:
		    		 deleteRestaurant(restaurants,resService);
		    	case 4:
		    		 updateRestaurant(restaurants,resService);
		    		 
                             
        	    }
            	} catch (Exception e) {
            		System.out.println(e.getMessage());
				}
               }while(choice<=4);
               
          
	    	  } catch (Exception e) {
		    	System.out.println(e.getMessage());
 	                             	}
               }
          
       public static void addRestaurants(Map<Integer, Restaurants > restaurants,RestaurantService resService) throws InvalidDetailException{
        Scanner sc = new Scanner(System.in);
    	   try {
			
		
    		   DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
    	   System.out.println("Enter Restaurants Details");
    	   System.out.println("Enter Restaurant Name");
    	   String resName = sc.nextLine();
    	   System.out.println("Enter Restaurant Owner User Name");
    	   String resOwner = sc.nextLine();
    	   System.out.println("Enter Restuarant Address");
    	   String resAddress = sc.nextLine();
    	   System.out.println("Enter Cuisine of your Restaurant");
    	   String resCuisine = sc.nextLine();
    	   System.out.println("Enter Restaurant Opening Time");
    	   String resOpenTime = sc.next();
    	   LocalTime openTime = LocalTime.parse(resOpenTime,format);
    	   System.out.println("Enter Restaurant Closing Time");
    	   String resCloseTime = sc.next();
    	   LocalTime closeTime = LocalTime.parse(resCloseTime,format);
    	   
   	    
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
    	   
    	   
    	  
    	   
    	   
    	   Restaurants  restaurant1 = new Restaurants(IdGeneration.generateId(), resName, resOwner,resAddress, resCuisine, openTime, closeTime, menuNum, map);
    	         resService.addRestaraunts(restaurant1, restaurants);    	   
    	   } catch (Exception e) {
                throw new InvalidDetailException("Invalid Input");
    	   
    	   }
          }
 
      public static void  custemerFunctionality(Map<Integer,Restaurants> resFile,Map<String,Customers> custFile) throws InvalidDetailException{
    	  
    	    Scanner sc  = new Scanner(System.in);
    	    
    	    
    	    int choice = 0;
    	    try {
				
    	    	do {
    	    		try {
						
					
    	    		System.out.println("Customer Login & Signup");
    	    	System.out.println("'1' ---> Log in");
    	        System.out.println("'2' ---> Sign up"); 
    	        System.out.println("'3' ---> Go to Main Page");
    	    	choice = sc.nextInt();
    	    	
    	    	switch (choice) {
				case 1:
					customerLogin(custFile,resFile);
					break;
				case 2:
					 customerSignup(custFile);
				    break;
				case 3:
//					 System.out.println("");
				}
    	    	
    	    		} catch (Exception e) {
    	    			System.out.println(e.getMessage());
  	    		}
    	        
    	    	}while(choice<=2);
    	    	
    	    	
			} catch (Exception e) {
			       System.out.println(e.getMessage());
			}
    	 }
      
      
      
      public static void customerSignup(Map<String,Customers> custfile) throws DuplicateDataException, InvalidDetailException {
    	  try {
			
    	  Scanner sc = new Scanner(System.in);
    	  
    	  System.out.println("Enter your First Name");
    	  String firstName = sc.nextLine();
    	  System.out.println("Enter your Last Name");
    	  String lastName = sc.nextLine();
    	  System.out.println("Enter your Address");
    	  String address = sc.nextLine();
    	  System.out.println("Enter your Number");
    	  long number = sc.nextLong();
    	  System.out.println("Enter User Name");
    	  Scanner sc1 = new Scanner(System.in);
    	  String userName = sc1.nextLine();
    	  System.out.println("Enter Password");
    	  String password = sc1.nextLine();
    	  System.out.println("Add Wallet Amount");
    	  long wallet = sc.nextLong();
    	  
    	  Customers cust  = new Customers(firstName, lastName, address, number, userName, password,wallet);
    	  CustomerService custService = new CustomerServiceImp();
            custService.signup(cust, custfile);    	  
    	  } catch (Exception e) {
    		  throw new InvalidDetailException("Invalid Input");
    		  
    	  }
     }
      
      
      public static void customerLogin(Map<String , Customers> custFile,Map<Integer,Restaurants> resFile ) throws InvalidDetailException
      {
    	  Scanner sc = new Scanner(System.in);
    	  CustomerService custService = new CustomerServiceImp();
    	  RestaurantService resService = new RestaurantServiceImp();
    	    CustLogin(custFile,custService);
    	     
    	    int choice = 0;
    	    
    	     try {
    	    	 do {
    	    		 System.out.println("'1' ---> View All Restaurants");
    	    		 System.out.println("'2; ---> Select Restaurant");
    	    		 choice = sc.nextInt();
    	    		 
    	    		 switch (choice) {
					case 1:
						viewAllRestaurants(resFile,resService);
					break;
					case 2:
						viewSelectedRestaurant(resFile,resService);
						
					default:
						throw new IllegalArgumentException("Unexpected value: " + choice);
					}
    	    		 
    	    	 }while(choice!=0);
    	    	 
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
    	  
      }
      
      public static void viewAllRestaurants(Map<Integer,Restaurants> resFile, RestaurantService  resService) throws RestuarantException
      {
    	  
    	  resService.viewAllRestarants(resFile);
    	  
      }
      
      public static void viewSelectedRestaurant(Map<Integer,Restaurants> resFile,RestaurantService resService) throws RestuarantException
      {
    	  
    	  
    	int key =  getRestaurant(resFile,resService);
    	
    	  Scanner sc = new Scanner(System.in);
    	  
    	  try {
    		  int choice = 0;
			do {
				
    	  System.out.println("'1' ---> Place order");
     	  System.out.println("'1' ---> Go Back");
    	  switch (key)
    	  {
    	  case 1:
    		  placeOrder(key,resFile,resService);
    	  break;
    	  case 2:
//    		  System.out.println("");
    		  break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
			}while(choice<=2);
    	  
    	  } catch (Exception e) {
    		  // TODO: handle exception
    	  }
	  }
      
     public static int getRestaurant(Map<Integer,Restaurants>  resFile, RestaurantService resService) throws RestuarantException {
    	 
    	 Scanner sc = new Scanner(System.in);
   	  
   	  System.out.println("Enter Restaurant Name");
   	  String resName = sc.nextLine();
   	  int key = -1;
   	  resName.toUpperCase();
   	  for(Map.Entry<Integer, Restaurants> i : resFile.entrySet())
   	  {
   		String resname =   i.getValue().getResturantName().toUpperCase();
   			  System.out.println(resname+" ----  "+ resName);
   		  if(resname.equals(resName))
   		  {
   			  key = i.getKey();
   			  break;
   		  }
   	  }
   	 
	if(key!=-1)
	{
		
	    Restaurants res=	resFile.get(key);
	    return key;
	    
	    

	}
	else
	{
		throw new RestuarantException("Restaurant Name Not Found");
	}
	
    }
     
    public static void placeOrder(int key,Map<Integer,Restaurants>resFile , RestaurantService resService)
    {
    	
    	
    	
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
 
 
 
 public static boolean CustLogin(Map<String,Customers> custFile , CustomerService custService) throws InvalidDetailException
 {
	           Scanner sc = new Scanner(System.in);
	           
	           System.out.println("Enter your User Name");
	        		  String userName = sc.next();
	       	 System.out.println("Enter your password");
	        		 String password = sc.next();
	       if(custService.login(userName, password, custFile))
	       {
	    	   return true;
	       }
	       else
	       {
	    	  return false;
	       }
	        		 
	        	   
	        		   
 }
	 
       public static void deleteRestaurant(Map <Integer,Restaurants> resFile,RestaurantService resService) throws RestuarantException {
	      Scanner sc = new Scanner(System.in);
	   if(resFile !=null && resFile.size()> 0)
       {
	 System.out.println("Enter Restaurant ID");
	    int id = sc.nextInt();
	    resService.deleteRestaurant(id, resFile);
	    
       }
       else
       {
       	throw new RestuarantException("Restaurant List is Empty");
       }
       }
	 
       public static String updateRestaurant(Map<Integer,Restaurants> resFile,RestaurantService resServive) throws InvalidDetailException, RestuarantException {
    	   String str =  null;
    	   if(resFile!=null && resFile.size()>0)
    	   {
    		   
    	   
    	   
    	   try {
			
    		   Scanner sc2 = new Scanner(System.in);
		
    		   DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
    		   System.out.println("Please Enter the Id of the restaurant do you want to update.");
    		   int idint = sc2.nextInt();
    		   Integer id = idint;
    		   
    		   if(!resFile.containsKey(id))
    		   {
    			   throw new InvalidDetailException("Id Not Found");
    	
    		   }
    		   
    		   Scanner sc = new Scanner(System.in);
    			
    	   System.out.println("Enter Restaurants Details");
    	   System.out.println("Enter Restaurant Name");
    	   String resName = sc.nextLine();
    	   System.out.println("Enter Restaurant Owner User Name");
    	   String resOwner = sc.nextLine();
    	   System.out.println("Enter Restuarant Address");
    	   String resAddress = sc.nextLine();
    	   System.out.println("Enter Cuisine of your Restaurant");
    	   String resCuisine = sc.nextLine();
    	   System.out.println("Enter Restaurant Opening Time");
    	   String resOpenTime = sc.next();
    	   LocalTime openTime = LocalTime.parse(resOpenTime,format);
    	   System.out.println("Enter Restaurant Closing Time");
    	   String resCloseTime = sc.next();
    	   LocalTime closeTime = LocalTime.parse(resCloseTime,format);
    	   
   	    
    	   System.out.println("Enter number of items do you want to add in your MENU");
    	   int menuNum = sc.nextInt();
    	    Map<Integer,Menu> map = new HashMap<>();
	    
    	   for(int i = 0;i<menuNum;i++)
    	   {
    		   Scanner sc1 = new Scanner(System.in);
    		   
    		   System.out.println("Enter Dish Name");
               String Men = sc1.nextLine();
               System.out.println("Enter cost of dish");
                int cost = sc1.nextInt();
                 Integer id1 = i+1;
                Menu item = new Menu(Men, cost);                 
                map.put(id1, item);  
                }
    	   
    	   
    	  
    	   
    	   Restaurants  restaurant1 = new Restaurants(idint, resName,resOwner, resAddress, resCuisine, openTime, closeTime, menuNum, map);
    	        str =  resServive.updateRestaurant(id,restaurant1, resFile);   
    	   
    	   return str;
    	   
    	   } catch (Exception e) {
                throw new InvalidDetailException("Invalid Input");
    	   
    	   }
    	   }
    	   else
    	   {
    		   throw new RestuarantException("List is Empty");
    	   }
    	   
       }
	 
	
	public static void main(String[] args) {
		
		Map<Integer, Restaurants> restaurants = FileExists.restaurantFile();
        Map< String ,ResOwners>	resOwners = FileExists.resOwners();
        Map<String , Customers > customers = FileExists.customerFile();
        
        
        

		
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Welcome, in MyDine Resturant.");
		try {
			
			int choice = 0;
			
			do {
				
				System.out.println("Please enter your Prefernce.");
				System.out.println("'1' ---> Admin Login.");
				System.out.println("'2' ---> Resturantant Owner.");
				System.out.println("'3' ---> Customer Login & Signup.");
				System.out.println("'0' ---> for exit.");
						choice = sc.nextInt();
						
				switch (choice) {
				
				case 1: 
					adminFunctionality(sc , restaurants);
				     break;
				case 2:
					
					break;
				case 3:
					custemerFunctionality( restaurants,  customers);
					break;
				}		
						
			}while(choice!=0);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			
			try {
				
				ObjectOutputStream poos = new ObjectOutputStream(new FileOutputStream("restaurants.ser"));
				poos.writeObject(restaurants);
				ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("Customers.ser"));
				coos.writeObject(customers);
				
				
			} catch (Exception e2) {
				// TODO: handle exception
				
			}
			
			
		}
		
	}
	
   
	
}
