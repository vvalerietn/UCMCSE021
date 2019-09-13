
public class Date {
	private int month;
	private int day;
	private int year;
	
	private int yearsDifferenceInDays;
	private int daysDifference;
	private int totalDifference;
	private int monthsDifference;
	
	//constructor with 3 inputs
	public Date(int month, int day, int year) {
		if (year >= 1900 && year <= 3000) {
			this.year = year;
		}
		if (month >= 1 && month <= 12) {
			this.month = month;
		}
		if (day >= 1 && day <= 31) {
			this.day = day;
		}
	}
	
	//given in project pdf
	public int dayOfYear() {
		int totalDays = 0;
		switch (month) {
		case 12: totalDays += 30;
		case 11: totalDays += 31;
		case 10: totalDays += 30;
		case 9 : totalDays += 31;
		case 8 : totalDays += 31;
		case 7 : totalDays += 30;
		case 6 : totalDays += 31;
		case 5 : totalDays += 30;
		case 4 : totalDays += 31;
		case 3 : totalDays += 28;
		case 2 : totalDays += 31;
		}
		totalDays += day;
		return totalDays;
	}
	
	//accessor method for month
	public int getMonth() {
		return month;
	}

	//accessor method for day
	public int getDay() {
		return day;
	}

	//accessor method for year
	public int getYear() {
		return year;
	}

	//compares bdays w each other
	public int compare(Date dt) {
		yearsDifferenceInDays = Math.abs((this.getYear() * 365) - (365 * dt.getYear()));
		daysDifference = Math.abs(dt.dayOfYear() - dayOfYear());
		totalDifference = Math.abs(yearsDifferenceInDays - daysDifference);
		monthsDifference = totalDifference / 30;
		
		if (monthsDifference > 60) {
			monthsDifference = 60;
		}
		return monthsDifference;
		
	}
	
}
