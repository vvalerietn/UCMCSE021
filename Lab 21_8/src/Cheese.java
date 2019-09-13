import java.util.Scanner;

public class Cheese {

	private String name;
	private double price;
	private double amount;

	public static int numCheese = 0;
	
	public Cheese() { // Constructor with no parameters
		name = "";
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name) { // Constructor with name as parameter
		this.name = name;
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name, double price) { // Constructor with 2 parameters
		// Fill-in Code
		this.name = name;
		this.price = price;
	}

	public String getName() { // Accessor
		return name;
	}

	public void setName(String newName) { // Mutator 
		name = newName;
	}

	public double getPrice() {
		// Fix Code
		return this.price;
	}

	public void setPrice(double newPrice) {
		// Fill-in Code
		this.price = newPrice;
		
	}

	public double getAmount() {
		// Fix Code
		return this.amount;
	}

	public void setAmount(Scanner input) {
		// Fill-in Code
		amount = 0;
		amount = input.nextDouble();
		while ((getAmount() < 0) || (getAmount() % 0.5 != 0)) {
        	if (getAmount() < 0) {
            	System.out.print("Invalid input. Enter a value that is >= 0: ");
            	amount = input.nextDouble();
            }
        	if (getAmount() % 0.5 != 0) {
            	System.out.print("Invaid input. Enter a value that's multiple of 0.5: ");
            	amount = input.nextDouble();
        	}
		
		}
	}
}


