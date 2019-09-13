package oop;

public class DecrementableCounter extends Counter {
	
	public void decrement() {
		int temp = super.value();

		super.reset();
		for(int i = 0; i < temp-1; i++) {
			super.increment();
		}
		
	}

}
