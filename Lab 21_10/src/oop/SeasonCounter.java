package oop;

public class SeasonCounter extends ModNCounter {

	
	private static String[] names =  {"spring", "summer", "fall", "winter"};
	
	public SeasonCounter() {
		//calls to ModCounter and it invokes that constructor
		super(4);
		
    }
	

	@Override
	public String toString() {
        // fill-in so it returns the season name

		return names[super.value()];
	}
}