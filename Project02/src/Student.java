
public class Student {

	private String studentName;
	private char gender;
	private Date bday;
	private Preference pref;
	private boolean matched;
	private int score;
	
	//constructor with 4 inputs
	public Student(String studentName, char gender, Date bday, Preference pref) {
		this.studentName = studentName;
		this.gender = gender;
		this.bday = bday;
		this.pref = pref;
	}
	
	//accessor method for name
	public String getName() {
		return studentName;
	}
	
	//accessor method for gender
	public char getGender() {
		return gender;	
	}
	
	//accessor method for birthdate
	public Date getBirthdate() {
		return bday;
	}
	
	//accessor method for pref
	public Preference getPref() {
		return pref;
	}
	
	//accessor method for match
	public boolean getMatch() {
		return matched;
	}
	
	//mutator method for matched
	public void setMatched(boolean match) {
		matched = match;
	}
	
	//compare & return compatability score 
	public int compare(Student st) {
		if (this.getGender() != st.getGender()) {
			score = 0;
		} else {
			int prefs = pref.compare(st.pref);
			int ageDiff = bday.compare(st.bday);
			score = (40 - prefs) + (60 - ageDiff);
		}
		return score;
	}
}
