package com.mydine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.mydine.entities.CustCart;
import com.mydine.entities.CustomerData;
import com.mydine.entities.Customers;
import com.mydine.entities.Menu;
import com.mydine.entities.ResOwners;
import com.mydine.entities.Restaurants;
import com.mydine.entities.Transactions;
import com.mydine.exceptions.DuplicateDataException;
import com.mydine.exceptions.InvalidDetailException;
import com.mydine.exceptions.RestuarantException;
import com.mydine.servie.CustomerCartService;
import com.mydine.servie.CustomerCartServiceImp;
import com.mydine.servie.CustomerService;
import com.mydine.servie.CustomerServiceImp;
import com.mydine.servie.RestaurantService;
import com.mydine.servie.RestaurantServiceImp;
import com.mydine.servie.TransactionFileImp;
import com.mydine.servie.TransactionService;
import com.mydine.utility.FileExists;
import com.mydine.utility.IdGeneration;

public class Main implements Serializable {

	
	
          private static void adminFunctionality(Scanner sc , Map<Integer,Restaurants> restaurants,  Map<String , Transactions> transactions) throws InvalidDetailException {
	 
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
        	     System.out.println("'5' ---> View All Customer Transactions");
        	     System.out.println("'6' ---> Go back");
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
		    		 break;
		    	case 4:
		    		 updateRestaurant(restaurants,resService);
		    		 break;
		    	case 5:
		    		 viewAllCustomerTransactions(transactions);
		    		 
                             
        	    }
            	} catch (Exception e) {
            		System.out.println(e.getMessage());
				}
               }while(choice<=5);
               
          
	    	  } catch (Exception e) {
		    	System.out.println(e.getMessage());
 	                             	}
               }
          
          
          
         public static void viewAllCustomerTransactions(Map<String , Transactions> Transactions) throws InvalidDetailException
          {
        	 if(Transactions !=null && Transactions.size()>0)
        	 {
        		 for(Map.Entry<String, Transactions> i : Transactions.entrySet())
        		 {
        			 System.out.println(i.getValue());
        		 }
        	 }
        	 else
        	 {
        		 throw new InvalidDetailException("No Transactions has been done yet");
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
//                throw new InvalidDetailException("Invalid Input");
                System.out.println(e.getMessage());
    	   
    	   }
          }
 
      public static void  custemerFunctionality(Map<Integer,Restaurants> resFile,Map<String,Customers> custFile,Map<String,CustCart> custCartFile,Map<String ,Transactions> transFile) throws InvalidDetailException{
    	  
    	    Scanner sc  = new Scanner(System.in);
    	    
    	    
    	    int choice = 0;
    	    try {
				
    	    	do {
    	    			
					
    	    		System.out.println("Customer Login & Signup");
    	    	System.out.println("'1' ---> Log in");
    	        System.out.println("'2' ---> Sign up"); 
    	        System.out.println("'3' ---> Go to Main Page");
    	    	choice = sc.nextInt();
    	    	
    	    	switch (choice) {
				case 1:
					customerLogin(custFile,resFile,custCartFile,transFile);
					break;
				case 2:
					 customerSignup(custFile);
				    break;
				case 3:
//					 System.out.println("");
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
      
      
      public static void customerLogin(Map<String , Customers> custFile,Map<Integer,Restaurants> resFile ,Map<String,CustCart> custCartFile,Map<String ,Transactions> transFile) throws InvalidDetailException
      {
    	  try {
    	  Scanner sc = new Scanner(System.in);
    	  CustomerService custService = new CustomerServiceImp();
    	  RestaurantService resService = new RestaurantServiceImp();
    	  CustomerCartService custCartFiles = new CustomerCartServiceImp();
    	  TransactionService transServiceFile = new TransactionFileImp();
    	    Scanner sc1 = new Scanner(System.in);
	           
	           System.out.println("Enter your User Name");
	        		  String userName = sc1.next();
	       	 System.out.println("Enter your password");
	        		 String password = sc1.next();
	       custService.login(userName, password, custFile);
	       
    	    int choice = 0;
    	    
    	    	 do {
    	    		 System.out.println("'1' ---> View All Restaurants");
    	    		 System.out.println("'2; ---> Select Restaurant");
    	    		 System.out.println("'3' ---> View Cart");
    	    		 System.out.println("'4' ---> Place Order");
    	    		 System.out.println("'5' ---> View Orders");
    	    		 System.out.println("'6' ---> Add Amount to wallet");
    	    		 System.out.println("'6' ---> Logout");
    	    		 
    	    		 choice = sc.nextInt();
    	    		 
    	    		
    	    		 switch (choice) {
					case 1:
						viewAllRestaurants(resFile,resService);
					break;
					case 2:
						viewSelectedRestaurant(resFile,resService,userName,custCartFile);
						break;
					case 3:
							viewCustomerCart(userName,custCartFile,custCartFiles);
							break;
					case 4:
					placeOrder(custCartFile,userName,custFile,transFile);
						break;
						
						
						
					case 5:
						
						transServiceFile.viewTransaction(transFile,userName);
						break;
					case 6 :
						
						addWallet(custFile,userName);
//						placeOrder()
    	    		 }
    	    		 
    	    	 }while(choice<=6);
    	    	 
    	    	 } catch (Exception e) {
    	    		 
    	    		 System.out.println(e.getMessage());
    	    		 // TODO: handle exception
    	    	 }
		}
      
      
      public static void addWallet( Map<String , Customers> custFile,String userName){
    	  
    	  Scanner sc = new Scanner(System.in);
    	  System.out.println("Enter Amount");
 long wallet = sc.nextLong();
 
    	  
    	 long custWallet =  custFile.get(userName).getWallet()+wallet;
    	 
    	  
      }
     public static void viewCustomerCart(String userName , Map<String , CustCart> custFile, CustomerCartService custCartFiles)
     {
    	 try {
			custCartFiles.viewCustomerCart(userName, custFile);
    	 
    	 } catch (Exception e) {
 
    	  System.out.println(e.getMessage());
    	 }
    	 
     }
      
      public static void placeOrder(Map<String,CustCart> custCartFiles,String userName,Map<String,Customers> custFile,Map<String ,Transactions> transFile) {
    	  
    	    System.out.println(custCartFiles.get(userName));
    	    long wallet = custFile.get(userName).getWallet();
    	    System.out.println("Wallet : "+wallet);
    	    Scanner sc = new Scanner(System.in);
    	    
    	    
    	    try {

    	    	 int choice = 0;
    	   do {
    		   
    	    System.out.println("'1' ---> To Confirm");
    	    System.out.println("'2' ---> Go back");
 
    	    choice = sc.nextInt();
    	    
    	    switch(choice) {
    	    
    	    case 1 :
    	    	orderPlaced(custCartFiles,userName,custFile,transFile,wallet);
    	    break;
    	    }
    	   }while(choice <=1);
    	    
    	    
    	    } catch (Exception e) {
    	    	// TODO: handle exception
    	    	System.out.println(e.getMessage());
    	    }
    	 
     }
      
      
    public static  void orderPlaced(Map<String,CustCart> custCartFile, String userName,Map<String,Customers> custFile,Map<String ,Transactions> transFile,long wallet) throws InvalidDetailException {
    	
    	try
    	{
    		
    	Customers cust = custFile.get(userName);
    	
    	String name = cust.getFirstName()+" "+cust.getLastName();
    	
    	long number = cust.getNumber(); 
    	
    	CustCart custCart = custCartFile.get(userName);
    	int total = custCartFile.get(userName).getTotal();
    	
    	if(wallet<total)
    	{
    		throw new InvalidDetailException("Wallet Amount is low");
    	}
    	LocalDate  date = LocalDate.now();
    	
    	LocalTime time = LocalTime.now();
    	
    	Map<String,CustCart> custCartList = new HashMap<>();
    	if(transFile.containsKey(userName))
    	{
    		
    		
    		
    	}
    	
    	custCartList.put(userName, custCartFile.get(userName));
    	
    	        
    	
    	
    	Transactions transaction = new Transactions(userName, name, number, custCartList, date, time);
    	
    	transFile.put(userName, transaction);
    	
    custFile.get(userName).setWallet(wallet-total);
    	custCartFile.remove(userName);
    	System.out.println("Order Placed Successfully"); 
    	
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	
    	
    }
      
    

	public static void viewAllRestaurants(Map<Integer,Restaurants> resFile, RestaurantService  resService) throws RestuarantException
      {
    	  try {
			
    	  
    	  resService.viewAllRestarants(resFile);
    	  
    	  } catch (Exception e) {
             System.out.println(e.getMessage());
    	  }
      }
      
      public static void viewSelectedRestaurant(Map<Integer,Restaurants> resFile,RestaurantService resService,String userName,Map<String,CustCart> custCartFile) throws RestuarantException
      {
    	  
    	  try {
    		
    	int key =  getRestaurant(resFile,resService);
    	if(key!=-1)
    	{
    		
    		resService.viewSelectedRes(key, resFile);
    		
    		
    	}
    	  Scanner sc = new Scanner(System.in);
    	  
    		  int choice = 0;
			do {
				
    	  System.out.println("'1' ---> Add To Cart");
     	  System.out.println("'2' ---> Go Back");
     	  choice  = sc.nextInt();
    	  switch (choice)
    	  {
    	  case 1:
    		  
    		  addToCart(key,resFile,resService,userName,custCartFile);
    	  break;
    	 
		}
			}while(choice<=1);
    	  
    	  } catch (Exception e) {
    		  
    		  System.out.print(e.getMessage());
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
     
    public static void addToCart(int key,Map<Integer,Restaurants>resFile , RestaurantService resService,String userName,Map<String,CustCart> custCartFile)
    {
    	
    	try {
        resService.viewMenu(key,resFile);	
    	
			
    	Scanner sc = new Scanner(System.in);
    	
    	  int choice = 0;
    	System.out.println("Enter Menu ID");
         
    	int id = sc.nextInt();
    	
    	System.out.println("Enter Quantity");
    	int qty = sc.nextInt();
    	
    	CustomerCartService custCartSer = new CustomerCartServiceImp();
    	
        String msg = custCartSer.addTocart(resFile, key, userName,id, qty, custCartFile);
    	
        System.out.println(msg);
    	 
        } catch (Exception e) {
        	
        	System.out.println(e.getMessage());
        }
    	
    	
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
 
 public static void restaurantFacility(Map <Integer,Restaurants> resFile,Map <String,Transactions> transFile ,Map<String,Customers> custFile) throws RestuarantException
 {
	 
	try {
		
	 
	 Scanner sc = new Scanner(System.in);
	System.out.println("Enter User Name");
	String userName = sc.nextLine();
	System.out.println("Enter Password");
	int password = sc.nextInt();
	
	if(resFile.containsKey(userName) && password==123)
	{
		
	}
	else
	{
		throw new RestuarantException("Invalid Credentials");
	}
	
	 
	} catch (Exception e) {
	      System.out.println(e.getMessage());
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
		   if(resFile.containsKey(id))
		   {
	    resService.deleteRestaurant(id, resFile);
	    
            }
		   else
		   {
			   throw new RestuarantException("invalid ID");
		   }
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
	 
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		Map<Integer, Restaurants> restaurants = FileExists.restaurantFile();
        Map< String ,ResOwners>	resOwners = FileExists.resOwners();
        Map<String , Customers > customers = FileExists.customerFile();
        Map<String , CustCart> custCart = FileExists.custCartFile();
        Map<String , Transactions> transactions = FileExists.transactionFile();
        
//        String filePath = "CustCart.ser"; // Replace with your file path

//        Map <String , CustCart> custCart1 = new HashMap<>();
//        Map <String , CustCart>  contentToWrite = custCart1;
//        FileExists.writeToFile(filePath, contentToWrite);

        // Read from the file
//        String contentRead = FileExists.readFromFile(filePath);
//        System.out.println("File content:");
//        System.out.println(contentRead);
//        

		
		
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
					adminFunctionality(sc , restaurants,transactions);
				     break;
				case 2:
					restaurantFacility(restaurants,transactions,customers);
					break;
				case 3:
					custemerFunctionality( restaurants,  customers,custCart,transactions);
					break;
				case 0:
					System.out.println("Sucessfully exited from system.");
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
				ObjectOutputStream cuoos = new ObjectOutputStream(new FileOutputStream("CustomersCart1.ser"));
				coos.writeObject(custCart);
				ObjectOutputStream toos = new ObjectOutputStream(new FileOutputStream("Transactions.ser"));
				coos.writeObject(transactions);
				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
				
			}
			
			
		}
		
	}
	
   
	
}
