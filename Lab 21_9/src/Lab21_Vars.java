import java.util.*;

public class Lab21_Vars {

	public static void main(String[] args) {

		int i = 0, j = 0;
		int var0, var1;
		
		// Fix 1: Correctly typecast 5.0 to an int so it can assigned to var3.
		//added a typecast on var3
		int var2 = 0, var3 = (int) 5.0;
		
		// Fix 2: Correctly declare a variable as an array.
		//added [] after int 
		int[] arri0 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		double[] arrd0 = {0.0, 1.0, 2.0, 3.0, 4.0};
		
		// Fix 3: What's wrong with temp? Fix it.
		//Initialized temp
		//set i and j equal to 0 in order to initialize
		if (i < j) {
			int temp = 0;
			System.out.println("Temp is " + temp);
		} else {
			int temp = 1;
			System.out.println("Temp is " + temp);
		}
		
		// Fix 4: Correctly calculate square of sums and print it as total.
		//remove the int in front of i
		//moved total outside of the for loop
		int total = 0;
		for (i = 0; i < 10; i++) {
			total += i*i;
		}
		System.out.println("i value is " + i);
		System.out.println("Total is " + total);
		
		// Fix 5: Figure out the logical error in lines 36-42, and correct it.
		//changed Cheese jack and added a new instance of that class
		Cheese jack = new Cheese();
		Cheese monterey = new Cheese("Monterey");
		jack = monterey;
		System.out.println("Monterey name is " + monterey.getName());
		jack.setName("Jack");
		System.out.println("Jack name is " + jack.getName());
		System.out.println("Monterey name is still " + monterey.getName());
	
		// Fix 6: Make the following code shorter by combining redundant 
		//        (unnecessary/duplicate) statements
		//added inputs for num1 and num2 outside of the if statement
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int num1 = input.nextInt();
		System.out.print("Enter second number: ");
		int num2 = input.nextInt();
		
		if (num1 > var3) {
			System.out.println("First is greater");
			if (num2 < var3)
				System.out.println("Second is Less than");
			else
				System.out.println("Second is Greater or equal");
		} else {
			System.out.println("First is Less than or equal");
			if (num2 < var3)
				System.out.println("Second is Less than");
			else
				System.out.println("Second is Greater or equal");
			
		}
		
		// Fix 7: Print out the first number entered by the user
		//        (Hint - You will need to modify the above code)
		System.out.println("First number was " + num1);
	}

}
