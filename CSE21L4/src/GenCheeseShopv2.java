import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	/*
	 * Displays the intro message informing the user of various cheeses sold 
	 * while populating the names and prices arrays, and initializing the
	 * amounts array.
	 */
	public static void intro(String[] names, double[] prices, double[] amounts) {
		int MAXCHEESE = amounts.length;
		
		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages):");
		
		if (MAXCHEESE >= 1) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
		}
		
		if (MAXCHEESE >= 2) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
			System.out.println(names[1] + ": $" + prices[1] + " per pound");
		}
		
		if (MAXCHEESE >= 3) {
			names[2] = "Teleme";
			prices[2] = 17.25;
			System.out.println(names[2] + ": $" + prices[2] + " per pound");
		}
		
	Random ranGen = new Random(100);

	for (int i = 3; i < MAXCHEESE; i++) {
		names[i] = "Cheese Type " + (char)('A' + i);
		prices[i] = ranGen.nextInt(1000)/100.0;
		amounts[i] = 0;

		System.out.println(names[i] + ": $" + prices[i] + " per pound");
	}
	
	System.out.print("\n");
	
	}
	
	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation 
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {

		int MAXCHEESE = amounts.length;
		for (int i = 0; i <MAXCHEESE; i++) {
			System.out.print("Enter the amount of " + names[i] + ": ");
			amounts[i] = sc.nextDouble();
			
			while ((amounts[i] < 0) || (amounts[i] % 0.5 != 0)) {
	        	if (amounts[i] < 0) {
	            	System.out.print("Invalid input. Enter a value that is >= 0: ");
	            	amounts[i] = sc.nextDouble();
	            }
	        	if (amounts[i] % 0.5 != 0) {
	            	System.out.print("Invaid input. Enter a value that's multiple of 0.5: ");
	            	amounts[i] = sc.nextDouble();
	        	}
			} 	
		}
	}
	
			
	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {

		int MAXCHEESE = amounts.length;
		int flag = 0;
		for (int i = 0; i < MAXCHEESE; i++){
			
			if (amounts[i] > 0) {
				System.out.println(amounts[i] + " lbs of " + names[i] + " @ " + prices[i] + " = $" + amounts[i]*prices[i]);	
				
			}
			else {
				flag++;
			}
		}
		
		if (flag == MAXCHEESE) {
			System.out.println("No items were purchased.");
		}
	}
	
	
	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		int MAXCHEESE = amounts.length;
		double oSubTotal = 0.0;
		
		for (int i = 0; i < MAXCHEESE; i++){
			
			if (amounts[i] > 0) {
				oSubTotal = oSubTotal + amounts[i]*prices[i];	
			}
		}
		
		return oSubTotal;
		
	}

	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices){
		
		double[] disSpecials = new double[2];
		
		//disSpecial{ [discHumbFog],[discRedH]}
		
		disSpecials[0] = 0.0; //HumbCount
        disSpecials[1] = 0.0; //discHumbFog
        disSpecials[0] = (prices[0] /2 * ((int)amounts[0]));
        
        if(amounts.length > 1) {
        	disSpecials[1] = (int)(amounts[1]/1.5) * 20.25; 
        }
        
		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
		// Fix
		 System.out.println("\n");
	     System.out.print("Original Sub Total: \t\t\t$");
	     System.out.printf("%.2f",subTotal);
	     System.out.println("\nSpecials...");
		
        //additional discounts
        if (disSpecials[0] != 0) {
        	System.out.println("Humboldt Fog (Buy 1 Get 1 Free): " + "\t-$" + disSpecials[0]);
        }
		
        if (disSpecials[1] != 0) {
        	System.out.println("Red Hawk (Buy 2 Get 1 Free): " + "\t\t-$" + disSpecials[1]);
        }

        if ((disSpecials[0] == 0) && (disSpecials[1] == 0)){
        	System.out.println("None. " + "\t\t\t\t\t-$0.00");
        }
        
        double newSubTotal = subTotal - (disSpecials[0] + disSpecials[1]);
        
        System.out.print("New Sub Total: " + "\t\t\t\t$");
        System.out.printf("%.2f",newSubTotal); 
        System.out.print("\n");
        
		return newSubTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		// Fill-in
		int discount = 0;
        double discCalc = 0.0;
        

        if (newSubTotal >= 150) {
        	discount = 10;
        	discCalc = 0.1;
        	
        }
        
        if (newSubTotal >= 250) {
        	discount = 15 + 10;
        	discCalc = 0.25;
        }
        
        double addDisc = newSubTotal * discCalc;
        System.out.print("Additional " + discount + "% Discount: " + "\t\t-$");
        System.out.printf("%.2f",addDisc);
        System.out.print("\n");
        
        double finalTotal = newSubTotal - addDisc;
        System.out.print("Final Total:\t\t\t\t$");
	        System.out.printf("%.2f",finalTotal);
	        System.out.print("\n");
	}
	
	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = sc.nextInt();

		
		if (MAXCHEESE == 0) {
			System.out.println("We sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages):");
			System.out.println("\n");
			System.out.println("Original Sub Total: \t\t\t $0.00");
			System.out.println("Specials...");
  			System.out.println("None");
  			System.out.println("Sub Total: \t\t\t\t $0.00");
  			System.out.println("Discount: \t\t\t\t -$0.00"); 
  			System.out.println("Final Total: \t\t\t\t $0.00");
			
			
		}else {
		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(sc, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);
		
		
		if (MAXCHEESE != 0 ) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();
			
			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));
		
		printFinalTotal(newSubTotal);
		
		sc.close();
	}
}
}