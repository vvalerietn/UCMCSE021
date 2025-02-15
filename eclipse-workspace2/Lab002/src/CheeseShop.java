import java.util.*;

public class CheeseShop {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
        
        double humbFog, redHawk, teleme;
        
        System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages).");
        System.out.println("Humoldt Fog: $25.00 per pound.");
        System.out.println("Red Hawk: $40.50 per pound.");
        System.out.println("Teleme: $17.25 per pound.");
        
        //user inputs in pounds, program converts to 0.5lbs increments
        
        //HumbFog
        System.out.print("Enter the amount of Humboldt Fog in lbs: ");
        humbFog = input.nextDouble();
        while ((humbFog < 0) || (humbFog % 0.5 != 0)) {
        	if (humbFog < 0) {
            	System.out.print("Invalid input. Enter a value that is >= 0: ");
            	humbFog = input.nextDouble();
            }
        	if (humbFog % 0.5 != 0) {
            	System.out.print("Invaid input. Enter a value that's multiple of 0.5: ");
            	humbFog = input.nextDouble();
        	}
        }
        
        //RedHawk
        System.out.print("Enter the amount of Red Hawk in lbs: ");
        redHawk = input.nextDouble();
        while ((redHawk < 0) || (redHawk % 0.5 != 0)) {
        	if (redHawk < 0) {
            	System.out.print("Invalid input. Enter a value that is >= 0: ");
            	redHawk = input.nextDouble();
            }
        	if (redHawk % 0.5 != 0) {
            	System.out.print("Invaid input. Enter a value that's multiple of 0.5: ");
            	redHawk = input.nextDouble();
        	}
        }
        
        //Teleme
        System.out.print("Enter the amount of Teleme in lbs: ");
        teleme = input.nextDouble();
        while ((teleme < 0) || (teleme % 0.5 != 0)) {
        	if (teleme < 0) {
            	System.out.print("Invalid input. Enter a value that is >= 0: ");
            	teleme = input.nextDouble();
            }
        	if (teleme % 0.5 != 0) {
            	System.out.print("Invaid input. Enter a value that's multiple of 0.5: ");
            	teleme = input.nextDouble();
        	}
        }
      
       //in order to determine to print out "No items were purchased."
        int countC = 0;
        
        //for HumbFog
        if (humbFog != 0) {
        	countC++;
        	humbFog = humbFog * 2; 
        }
        
        //for Red Hawk ; return total RedHawk
        if (redHawk % 1 == 0) {
        	countC++;
        	redHawk = redHawk + (redHawk / 2);
        }else {
        	countC++;
        	redHawk = redHawk + ((int)redHawk * 0.5);
        }
        
        //calculations
        double hfPrice = humbFog * 25.0;
        double rhPrice = redHawk * 40.5;
        double tPrice = teleme * 17.25;
        
        //display the itemized list 
        System.out.print("\nDisplay the itemized list? (1 for yes) ");
        int itemizedList;
        itemizedList = input.nextInt();
        
        if (itemizedList == 1) {
        	if((humbFog == 0) && (redHawk == 0) && (teleme == 0)) {
        		System.out.println("No items were purchased.");
        	}
        	else {
        	System.out.println(humbFog + " lb of Humboldt Fog @ $25.0 = $" + hfPrice );
        	System.out.println(redHawk + " lb of Red Hawk @ $40.5 = $" + rhPrice);
        	System.out.println(teleme + " lb of Teleme @ $17.25 = $" + tPrice);
        	}
        }
      
        //display subtotal 
        double subtotal = (hfPrice + rhPrice + tPrice);
        System.out.println("\nSubtotal: $" + subtotal);
        System.out.println("Discounts...");
        
        //if statement to find out total discounts
        
        double discRedHawk = (rhPrice / 3);
        double discHumbFog = (humbFog / 2.0) * (25.0);
        if (countC == 0) {
    	   System.out.print("None." + "\t\t\t -$0.0");
       }
        else {
        System.out.println("Humboldt Fog (Buy 1 Get 1 Free): " + "\t -$" + discHumbFog);
        System.out.println("Red Hawk (Buy 2 Get 1 Free): " + "\t\t -$" + discRedHawk);
       }
      
       double totalCost = subtotal - (discHumbFog + discRedHawk);
       System.out.println("Total: " + "\t\t\t\t\t $" + totalCost);
       
	}

}
