public class Lab21_5 {

	public static void init(long[] arr) {
		// Initialize all the entries of the array to 0
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

	public static long sumAll(int max) {
		// sumAll basic version
		long subTotal = 0;
		for (int i = 1; i <= max; i++) {
			subTotal += i;
			System.out.println("sumAll " + i + " value " + subTotal);
		}
		return subTotal;
	}
	
	public static long sumAll(long[] arr, int max) {
		// Use the array to store sub results
		for (int i = 1; i <= max ; i++) {
			if (arr[i] == 0) {
				arr[i] = arr[i-1] + i;	
				System.out.println("sumAll[" + i + "] value " + arr[i]);
			}
		}
		return arr[max];

	}
	
	public static long squareSum( int max) {
		int total = 0;
		for (int i = 1; i <= max; i++) {
			total += i*i;
			System.out.println("squareSum " + i + " value " + total);
		}
		
		return total;
		
	}
	
	public static long squareSum(long[] arr, int max) {
		// Use the array to store sub results
		int total = 0;
				for (int i = 1; i <= max ; i++) {
					
					if (arr[i] == 0) {
						arr[i] = i * i;	
						System.out.println("squareSum[" + i + "] value " + (arr[i] + total));
					}
					total += arr[i];
				}
				return total;

		
	}
	public static long fib( int max) {
		if(max <= 1) {
			return max;
		}
		int fib = 1;
		int fib2 = 1;
		for(int i = 2; i <= max; i++) {
			int temp = fib;
			fib += fib2;
			fib2 = temp;
			System.out.println("Fibonacci " + i + " value " + fib2);
		}
		
		return fib2;
	}
	public static long fib(long[] arr, int max) {
		int total = 0;
		if(max <= 1) {
			return max;
		}
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= max; i++) {
			if(arr[i] == 0) {
			arr[i] = arr[i-1] + arr[i-2];
			System.out.println("Fibonacci[" + i + "] value " + arr[i]);
		}
		}
		return arr[max];
	}
	
	public static long factorial(int max) {
		long total = 1;
		for(int i = 2; i <= max; i++) {
			total *= i;
			System.out.println("Factorial " + i + " value " + total);
		}
		return total;
	}
	
	public static long factorial(long[] arr, int max) {
		// Use the array to store sub results
		arr[1] = 1;
		for (int i = 2; i <= max; i++) {
			if (arr[i] == 0) {
				arr[i] = i * arr[i-1];	
				System.out.println("Factorial[" + i + "] value " + arr[i]);
			}
			
		}
		return arr[max];

	}
	
   // Fill-in the appropriate methods to complete the lab

	public static void main(String[] args) {

		final int MAXSIZE = 100;
		long[] arr = new long[MAXSIZE];

		System.out.println("sumAll output for 5 is " + sumAll(5));
		System.out.println("sumAll output for 10 is " + sumAll(10));
		System.out.println("sumAll output for 20 is " + sumAll(20));
		System.out.println("sumAll output for 15 is " + sumAll(15));
		System.out.println();

		init(arr);
		System.out.println("sumAll output for 5 is " + sumAll(arr, 5));
		System.out.println("sumAll output for 10 is " + sumAll(arr, 10));
		System.out.println("sumAll output for 20 is " + sumAll(arr, 20));
		System.out.println("sumAll output for 15 is " + sumAll(arr, 15));
		System.out.println();


		System.out.println("squareSum output for 5 is " + squareSum(5));
		System.out.println("squareSum output for 10 is " + squareSum(10));
		System.out.println("squareSum output for 20 is " + squareSum(20));
		System.out.println("squareSum output for 15 is " + squareSum(15));
		System.out.println();

		init(arr);
		System.out.println("squareSum output for 5 is " + squareSum(arr, 5));
		System.out.println("squareSum output for 10 is " + squareSum(arr, 10));
		System.out.println("squareSum output for 20 is " + squareSum(arr, 20));
		System.out.println("squareSum output for 15 is " + squareSum(arr, 15));
		System.out.println();

		System.out.println("Fibonacci Number 5 is " + fib(5));
		System.out.println("Fibonacci Number 10 is " + fib(10));
		System.out.println("Fibonacci Number 20 is " + fib(20));
		System.out.println("Fibonacci Number 15 is " + fib(15));
		System.out.println();

		init(arr);
		System.out.println("Fibonacci Number 5 is " + fib(arr, 5));
		System.out.println("Fibonacci Number 10 is " + fib(arr, 10));
		System.out.println("Fibonacci Number 20 is " + fib(arr, 20));
		System.out.println("Fibonacci Number 15 is " + fib(arr, 15));
		System.out.println();

		System.out.println("Factorial of 5 is " + factorial(5));
		System.out.println("Factorial of 10 is " + factorial(10));
		System.out.println("Factorial of 20 is " + factorial(20));
		System.out.println("Factorial of 15 is " + factorial(15));
		System.out.println();

		init(arr);
		System.out.println("Factorial of 5 is " + factorial(arr, 5));
		System.out.println("Factorial of 10 is " + factorial(arr, 10));
		System.out.println("Factorial of 20 is " + factorial(arr, 20));
		System.out.println("Factorial of 15 is " + factorial(arr, 15));
	
	}


}
