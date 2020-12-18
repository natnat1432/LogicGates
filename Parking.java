/*
C. Write a program that given the type of vehicle (c for car, b for bus, t for truck) and the hours a vehicle spent in the parking lot, returns the parking charge based on the rates shown below:
car - PHP20.00 per hr
bus - PHP35.00 per hr
truck- PHP50.00 per hr

Example:
Enter vehicle type: t
Parking duration(hrs): 5
Total parking charge: PHP250.00

Note: consider that parking duration may be a decimal value. example 2.5 --> two and a half hours .
*/

import java.util.Scanner;
public class Parking
{
   public static void main(String [] args)
   {
      Scanner in = new Scanner(System.in);
      String vehicle;
      String hours;
      boolean yesvehicle= false;
      double vehicleRate=0;
      double hourTemp;
     
      String v=null;
      //Using do while looping in Sanitizing user input and using if conditioning.
      do{
      vehicle = null;
      System.out.println("-------------------------------------");
      System.out.println("PARKING PROGRAM");
      System.out.println("-------------------------------------");
      System.out.println("RATES:");
      System.out.println("-------------------------------------");
      System.out.println("[C] - Car - PHP20.00/hr\n[B] - Bus - PHP35.00/hr\n[T] - Truck - PHP50.00/hr");
      System.out.println("-------------------------------------\n\n");
      System.out.print("Enter Vehicle Type: ");
      vehicle = in.next().toLowerCase();
      
    
 
      if(!((vehicle.charAt(0)=='c') ||  (vehicle.charAt(0)=='b') || (vehicle.charAt(0)=='t')))
      {
      System.out.println("\n\n-------------------------------------\n");
      System.out.println("Error Input! Please try again.");
      System.out.println("-------------------------------------\n\n\n");
      }
      if((vehicle.charAt(0)=='c') ||  (vehicle.charAt(0)=='b') || (vehicle.charAt(0)=='t'))
      {
       yesvehicle = true;  
      }
      }while(yesvehicle==false);
      
      
      //Using Try and Catch in sanitizing number of hours input.

        while (true) {
             System.out.print("Parking duration(hrs): ");
             hours = in.next();
          hourTemp = 0;
            try {
                hourTemp = Double.parseDouble(hours);
                break;
            } catch (NumberFormatException ne) {
               System.out.println("\n\n-------------------------------------\n");
               System.out.println("Error Input! Please input a number.");
               System.out.println("-------------------------------------\n\n\n");
            }
        }
        
        //Setting the vehicle rates and Vehicle string basing on the type of vehicle entered.
        if(vehicle.charAt(0)=='c')
        {
         v = "Car";
         vehicleRate=20;
        }
        else if(vehicle.charAt(0)=='b')
        {
         v = "Bus";
         vehicleRate=35;
        }
        else if(vehicle.charAt(0)=='t')
        {
         v = "Truck";
         vehicleRate=50;
        }
        
         double hoursInteger = hourTemp;
        //Getting the total fee using double as variable.
        double total = hoursInteger*vehicleRate; 
        //Converting Hours double to int for subtraction to be used in displaying minutes.
        int hourInt = (int)hoursInteger;
        //Getting the minutes.
        int minutes = (int)((hoursInteger-hourInt)*60);
        
        //Output.
        System.out.println("\n\nPARKING PROGRAM");
        System.out.println("-------------------------------------");
        System.out.println("Vehicle Type: "+v);
        System.out.println("Parking duration(hrs): "+hours+" | "+ hourInt +" Hour/s and "+minutes+" minute/s");
        //Displaying the total fee as currency format.
        System.out.printf("Total Parking Charge: PHP%.2f",total);
        System.out.println();
        System.out.println("-------------------------------------");
      
      
   }
}