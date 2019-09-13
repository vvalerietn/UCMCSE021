
import java.util.Scanner;

public class Shop {
	static double discount = 0; 	 //global variable
	static double discount1 = 0;	 //global variable
	
	//in order to make things like "1st" or "2nd", etc... 
	public static String numSuffix(int i) {
		int rem = i % 10;
		switch (rem) {
			case 0:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				return (i + "th");
			case 1:
				if (i % 100 != 11) 
					return (i + "st");
				else 
					return (i + "th");	
			case 2:
				if (i % 100 != 12)
					return (i + "nd");
				else 
					return (i + "th");
			case 3: 
				if (i % 100 != 13)
					return (i + "rd");
				else 
					return (i + "th");
			default: 
				break;
					
		}
		return "";
	}
	
	//set up shop
	public static int Setup(Scanner input, String[] names, double []prices, double[] discounts) {
		System.out.print("Please enter the number of items to set up shop: ");
		int items = input.nextInt();
	
		System.out.println("");
		for (int i = 0; i < items; i++) {
			System.out.print("Enter name of the " + numSuffix(i+1) + " product: ");
			names[i] = input.next();
			
			System.out.print("Enter price the per package price of " + names[i] + ": ");
			prices[i] = input.nextDouble();
			
			System.out.print("Enter the number of packages ('x') to qualify for Special Discount (buy 'x get 1 free for " + names[i] + ", or 0 if no Special Discount offered: " );
		    discounts[i] = input.nextDouble();
		
		}
		
		//additional discount
        System.out.println("");
        System.out.print("Enter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
        discount = input.nextDouble();
        
        if (discount != 0) {
        	System.out.print("Enter the Additonal Discount Rate (e.g., 0.1 for 10%): ");
            discount1 = input.nextDouble();
            
            while((discount1 < 0.0) || (discount1 > 0.5)) {
                System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
                discount1 = input.nextDouble();
            }
        }

        System.out.println("");
		return items;
		
	} 
	
	//How to buy items
	public static void Buy(Scanner input, String[] names, double[] prices, int[] amounts, int items) {
	
		for (int i = 0; i < items; i++){
			System.out.print("Enter the number of " + names[i] + " packages to buy: ");
            amounts[i] = input.nextInt();
            while (amounts[i] < 0) {
            	System.out.print("Invalid input. Enter a value >= 0: ");
            	amounts[i] = input.nextInt();
            }
			
		}
		
	}
	
	//How to list items
	public static void List(String [] names, double[] prices, int[] amounts, int items) {
		int count = 0;
		
		for(int i = 0; i < items; i++) {
			if (amounts[i] > 0) {
				if (amounts[i] != 1) {
					System.out.print(amounts[i] + " packages of " + names[i] + " @ $" + prices[i] + " per pkg = $");	
					double price = amounts[i] * prices[i];
					System.out.printf("%.2f", price); 
					System.out.println();
					count++;
			
				}
				if (amounts[i] == 1)	
					System.out.print(amounts[i] + " package of " + names[i] + " @ $" + prices[i] + " per pkg = $");
					double price = amounts[i] * prices[i];
					System.out.printf("%.2f", price); 
					System.out.println();
					count++;
				
			}
		}
		if (count == 0) {
			System.out.println("No items were purchased.");
		}
	}
	
	public static void Checkout(double[] prices, int[] amounts, double[] discounts, int items, double[] specDiscVal) {
		
		//original sub total
		double oSubTotal = 0;
		
		for(int i = 0; i < amounts.length; i++) {
		oSubTotal = (prices[i]*amounts[i]) + oSubTotal;
		}
		
		//special discount value
		double discValue = 0;
		
		for (int i = 0; i < items; i++) {
			if (discounts[i] > 0 && amounts[i] > 0) {
				specDiscVal[i] = (int)(amounts[i] / (discounts[i] + 1)) * prices[i]; 
			}
			if (discounts[i] == 0 || amounts[i] == 0) { 
				specDiscVal[i] = 0;
			}
	
		}
		
		for (int i = 0; i < items; i++) {
			discValue += specDiscVal[i];
		}
		
		//new sub total 
		double nSubTotal = oSubTotal - discValue;
		
		//additional discount
		double addDisc = discount1 * nSubTotal;
		
		//final total
		double finalTotal = nSubTotal - addDisc;
		
		
		if (oSubTotal >= discount){
			System.out.println();
			
			System.out.print("Original Sub Total: \t\t$");
			System.out.printf("%.2f", oSubTotal);
			System.out.println(); //skip line
			
			if (discValue == 0) {
				System.out.println("No Special Discounts were applied");
			} else {
				System.out.print("Special Discount: \t\t-$");
				System.out.printf("%.2f", discValue); 
				System.out.println(); //skip line
			}
			
            System.out.print("New Sub Total: \t\t\t$");
			System.out.printf("%.2f", nSubTotal); 
			System.out.println(); //skip line
            
			if (addDisc == 0) {
				System.out.println("You did not qualify for an Additional Discount");
			} else {
				System.out.print("Additional " + (discount1 * 100) + "% Discount: \t-$");
				System.out.printf("%.2f", addDisc);
				System.out.println();//skip line
			}
			
			System.out.print("Final Total: \t\t\t$");
			System.out.printf("%.2f", finalTotal);
			System.out.println();//skip line

			System.out.println("\nThanks for coming!\n");

		}
		else if (oSubTotal < discount){
			System.out.println();
			
			System.out.print("Original Sub Total: \t\t$");
			System.out.printf("%.2f", oSubTotal);
			System.out.println(); //skip line
			
			System.out.print("Special Discount: \t\t-$");
			System.out.printf("%.2f", discValue); 
			System.out.println(); //skip line
			
            System.out.print("New Sub Total: \t\t\t$");
			System.out.printf("%.2f", nSubTotal); 
			System.out.println(); //skip line
			
			System.out.print("Final Total: \t\t\t$");
			System.out.printf("%.2f", finalTotal);
			System.out.println();//skip line

			System.out.println("\nThanks for coming!\n");
		}
	
	}

	
	public static void main(String[] args) {
		final int MAX = 100;
		int set = 0;
		int buy = 0;
		int items = 0;
		
		String[] names = new String[MAX];
		double[] prices = new double[MAX];
		int[] amounts = new int[MAX];
		double[] discounts = new double[MAX];
		double[] specDiscVal = new double[MAX];
		
		do{
			Scanner input = new Scanner(System.in);
			System.out.println("This program supports 4 functions:");
			System.out.println("\t1. Setup Shop");
			System.out.println("\t2. Buy");
			System.out.println("\t3. List Items");
			System.out.println("\t4. Checkout");
			System.out.print("Please choose the function you want: ");
			int func = input.nextInt();
			
		if ( 1 <= func || func >= 4){
		
		// User can run setup multiple times so keep the latest version		
		if (func == 1){
			if (set == 0 || set == 1){
				items = Setup (input, names, prices, discounts);
			}
			
			set = 1;
			
		}
		
		if (func == 2){
			if (set == 1){
				System.out.println();
				Buy(input, names, prices, amounts, items);
				System.out.println();
				
				
			}
			else{ 
				System.out.println();
				System.out.print("Shop is not setup yet!"); 
				System.out.println();
				System.out.println();// 1. If setup is not done yet, telling customer to setup shop first
				
		}
			buy = 1;
			
		}
			
		if (func == 3){
		
			if (buy == 1){
			System.out.println();
			List(names, prices, amounts, items);
			System.out.println();
		}		
		
			if (set == 1 && buy == 0){
			System.out.println();
			System.out.println("You have not bought anything!");
			System.out.println(); //2. If setup is done but the customer has not bought anything then ask to buy first
			
			
		}	
			if (set == 0){
			System.out.println();
			System.out.println("Shop is not setup yet!");
			System.out.println();//1. If setup is not done yet then tell customer to setup shop first
		}
				
		}
		
		
		if (func == 4){
			if (set == 0){
				System.out.println();
				System.out.println("Shop is not setup yet!");
				System.out.println(); // If setup is not done yet then tell customer to setup shop first
				continue;
		}
			if (buy == 0){
				System.out.println();
				System.out.println("You have not bought anything!");
				System.out.println(); //If setup is done but the customer hasnÕt bought anything then ask to buy first
				continue;
		}
			if (buy == 1){
				Checkout(prices, amounts, discounts, items, specDiscVal);
				
				System.out.println("-----------------------");
				System.out.print("Would you like to re-run (1 for yes, 0 for no)? ");
				int reRun = input.nextInt();
				System.out.println("-----------------------");
				if (reRun == 1) {
					set = 0;
					buy = 0;
					items = 0;
					// in order to reset and start over again
					continue;
				}
				else {
					break;
				}
		} 	
				
			}
	
		
		else if (func > 4){
			System.out.println();
			System.out.println("Error: Do not know " + func);	
			System.out.println();
		}	
		
			}
		}
		while(true);
			}
}
