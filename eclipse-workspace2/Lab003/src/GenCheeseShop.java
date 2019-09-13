import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int MAXCHEESE; 
		double oSubTotal = 0.0;
		
		
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = input.nextInt();
		
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];
		
		// Three Special Cheeses
		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese:");
		
		//if (MAXCHEESE == 0) {
		//	System.out.println("We sell 0 kinds of Cheese (in 0.5 lb packages)");
		//}
		
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
		
		//the listing of cheese types
 		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese:");

 		Random ranGen = new Random(100);

		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}
		
		System.out.print("\n");
		
		//inputs for cheese
		for (int i = 0; i <MAXCHEESE; i++) {
			System.out.print("Enter the amount of " + names[i] + ": ");
			amounts[i] = input.nextDouble();
			
			while ((amounts[i] < 0) || (amounts[i] % 0.5 != 0)) {
	        	if (amounts[i] < 0) {
	            	System.out.print("Invalid input. Enter a value that is >= 0: ");
	            	amounts[i] = input.nextDouble();
	            }
	        	if (amounts[i] % 0.5 != 0) {
	            	System.out.print("Invaid input. Enter a value that's multiple of 0.5: ");
	            	amounts[i] = input.nextDouble();
	        	}
	        }
			
			oSubTotal = oSubTotal + (amounts[i]*prices[i]); //  total all the cheese
		}
		
		//display the itemized list 
        System.out.print("\nDisplay the itemized list? (1 for yes) ");
        int itemizedList = input.nextInt();
        
        if (itemizedList == 1){
			for (int i = 0; i < MAXCHEESE; i++){
			
				if (amounts[i] > 0)
					System.out.println(amounts[i] + " lbs of " + names[i] + " @ " + prices[i] + " = $" + amounts[i]*prices[i]);
				
			}
		}
        
        int discount = 0;
        double discCalc = 0.0;
        //additional discounts
        double discHumbFog = 0.0;
        discHumbFog = (prices[0] /2 * ((int)amounts[0]));
        
        double discRH = 0.0;
        
        
        if(amounts.length > 1) {
        discRH = (int)(amounts[1]/1.5) * 20.25; 
        
        }
        double nSubTotal = oSubTotal - (discHumbFog + discRH);
       
        if (nSubTotal >= 150) {
        	discount = 10;
        	discCalc = 0.1;
        	
        }
        
        if (nSubTotal >= 250) {
        	discount = 15 + 10;
        	discCalc = 0.25;
        }
        double addDisc = nSubTotal * discCalc;
        double finalTotal = nSubTotal - addDisc;
        
        //totals
        System.out.println("\n");
        System.out.print("Original Sub Total: \t\t\t$");
        System.out.printf("%.2f",oSubTotal);
        System.out.println("\nSpecials...");
       
        if (discHumbFog != 0) {
        	System.out.println("Humboldt Fog (Buy 1 Get 1 Free): " + "\t-$" + discHumbFog);
        }
		
        if (discRH != 0) {
        	System.out.println("Red Hawk (Buy 2 Get 1 Free): " + "\t\t-$" + discRH);
        }

        if ((discHumbFog == 0) && (discRH == 0)){
        	System.out.println("None. " + "\t\t-$0.0");
        }
        
     //   double nSubTotal = oSubTotal - (discHumbFog + discRH);
        System.out.print("New Sub Total: " + "\t\t\t\t$");
        System.out.printf("%.2f",nSubTotal); 
        System.out.print("\n");
        
       // double addDisc = nSubTotal * discCalc;
        System.out.print("Additional " + discount + "% Discount: " + "\t\t-$");
        System.out.printf("%.2f",addDisc);
        System.out.print("\n");
        
        //double finalTotal = nSubTotal - addDisc;
        System.out.print("Final Total:\t\t\t\t$");
        System.out.printf("%.2f",finalTotal);
        System.out.print("\n");
        
        if (MAXCHEESE == 0){
        	System.out.println("We sell 0 kinds of Cheese");
  			System.out.println("");
  			System.out.println("Sub Total: $0.0");
  			System.out.println("-Discount: $0.0"); 
  			System.out.println("Total" + "  $0.0");
  		}
	}
        
}


