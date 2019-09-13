import java.util.*;
  
public class RemainderFunc {

        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);

                int maxnum;
                int divisor;
                int count = 0;

                //can also run through 0 as a max number
                System.out.print("Please enter the max number: ");
                maxnum = input.nextInt();
                while (maxnum < 0) {
                	System.out.print("Invalid input. Please enter a valid max number (>= 0): ");
                	maxnum = input.nextInt();
                }
               	
                
                System.out.print("Please enter the divisor: ");
                divisor = input.nextInt();
                while (divisor <= 0) {
                	System.out.print("Invalid input. Please enter a valid divisor number (>= 0): ");
                	divisor = input.nextInt();
                }
                
                               
                System.out.println("Multiples of " + divisor + " between 1 and " + maxnum + " (inclusive) are: ");

                

                for (int i = 1; i < maxnum; i++) {
                	if ((i % divisor) == 0) {
                		System.out.println(i);
                    	count++;
                    }
                }
                
                if (count == 0) {
                	System.out.print("No number were found.");
                }
                
                }
        }
