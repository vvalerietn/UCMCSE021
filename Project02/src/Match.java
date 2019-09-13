import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.IOException;

public class Match {

	public static void main(String[] args) throws IOException {
		//sets an array of students max is 100
		Student[] slist = new Student[100];
		
		//choose the file to read from (given in Parser.java)
		System.out.print("\nEnter the name of file to open: ");
		Scanner kbd = new Scanner(System.in);
		String filename = kbd.next(); 
		
		try { // text reader 
			
			int i = 0;
			//Scanner for reading of file
			Scanner fileReader = new Scanner (new FileReader(filename));

			//will continue to run if there is a nextLine
			System.out.println("Reading " + filename + " ... ");
			
			while (fileReader.hasNextLine()) {
				
				//reading text values & stores into variables 
				Scanner text = new Scanner(fileReader.nextLine());
				text.useDelimiter("[\t]"); 
				// Tab (\t) and/or space ( ) and/or carriage return (\r) delimited file	
				String name = text.next();
				String gender = text.next();
				String date = text.next();
				
				//String date --> ints & stores into ints
				Scanner num = new Scanner(date);
				num.useDelimiter("-");
				int month = num.nextInt();
				int day = num.nextInt();
				int year = num.nextInt();
				
				//reading preferences 
				int quietTime = text.nextInt();
				int music = text.nextInt();
				int reading = text.nextInt();
				int chatting = text.nextInt();
			
				
				//using constructors with parameters
				Date bday = new Date(month, day, year);
				Preference pref = new Preference(quietTime, music, reading, chatting);
				
				//add student to created array of students
				Student newStud = new Student(name, gender.charAt(0), bday, pref);
				slist[i++] = newStud;
				
				text.close();
				num.close();	
			}

		System.out.println("File is read. Matching students currently");	
		System.out.println("===========================================\n");
		
		//runs through slist array to compare with each student 
		int max = i;
		for (i = 0; i < max; i++) {
			if (!slist[i].getMatch()) {
				int bestScore = 0;
				int bestMatch = 0;
				for (int j = i + 1; j < max; j++) {
					if (!slist[j].getMatch()) {
						int stud = slist[i].compare(slist[j]);
						if (stud > bestScore) {
							bestScore = stud;
							bestMatch = j;
						}
					}
					
				}
				
			//match students with their best score 
			if (bestScore != 0) {
				slist[i].setMatched(true);
				slist[bestMatch].setMatched(true);
				
				//printing out which students match with each other
				System.out.println(slist[i].getName() + " matches with " + slist[bestMatch].getName() + " with the score " + bestScore);
				
				
			}
			else {
				if (!slist[i].getMatch()) {
					System.out.println(slist[i].getName() + " has no matches.");
				}
			}
			}
		}
		
		fileReader.close();
		
		System.out.println("===========================================");
		System.out.println("Closing file.");
		kbd.close();
		} catch(FileNotFoundException e) { // Catch Error 
			System.out.println(e); 
		} catch(NoSuchElementException e) { // Catch Error 
			System.out.println(e); 
		}
	}

}
