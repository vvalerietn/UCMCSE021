import java.util.Scanner;

public class AllAverageArr {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int newNumber = 0;
		int i = 0;
		int sum = 0;
		
		System.out.println("This program will find the average of any numbers.");
		System.out.print("Please chose the amount of numbers to average: ");
		int max = input.nextInt();
		int[]arr = new int[max+1];
		
		System.out.print("Please choose the amount of columns: ");
		int col = input.nextInt();
		System.out.println();
		
		do {
			System.out.print("Please enter " + (i+1) + " number: ");
			newNumber = input.nextInt();
			arr[i]= newNumber;
			
			if (max > i) {
				sum = sum + newNumber;
				i++;
			}
	
		}
		while (max > i);
		
		System.out.println();
		System.out.println("The numbers being averaged:");
		
		for(i = 0; i < max; i++){
			
			if(i % col == 0) {
				System.out.println();
			}
			
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Average is: " + ((float)sum/(float)i));
		}

}

