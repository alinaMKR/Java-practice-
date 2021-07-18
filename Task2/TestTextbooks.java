package Task2;

//import necessary utilities
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//create a class to Test Textbooks
public class TestTextbooks {
	public static void main (String [] args) {
		
		//create array list for textbooks
		List<Textbook>textbookList = new ArrayList<>();
		
	
	//* create new Programming Textbooks
	
	//create the first one
		// set fields as from superclass
		ProgrammingTextbook progbook1 = new ProgrammingTextbook("Introduction to Algorithms", "Thomas Cormen", "521");
		//set additional field language
		progbook1.setLanguage("English");
		// add new book to the list
		textbookList.add(progbook1);
	
	//create the second Programming Book
		// set fields as from superclass
		ProgrammingTextbook progbook2 = new ProgrammingTextbook ("IntroductIon to Java" + 
				"Programming and Data Structures", "Daniel Liang", "1219");
		//set additional field language
		progbook2.setLanguage("Russian");
		// add new book to the list
		textbookList.add(progbook2);
	
	//create third Programming Book
		// set fields as from superclass
		ProgrammingTextbook progbook3 = new ProgrammingTextbook ("Clean Code: A Handbook of Agile Software" + 
		" Craftsmanship", "Robert Martin", "704");
		//set additional field language
		progbook3.setLanguage("Italian");
		// add new book to the list
		textbookList.add(progbook3);
	
	//* create new Engineering Textbooks 
	//create the first one
		// set fields as from superclass
		EngineeringTextbook engbook1 = new EngineeringTextbook("The Tractor Book", "Dorling Kindersley", "853");
		//set additional field subject 
		engbook1.setSubject("Agricultural Engineering & Machinery");
		// add new book to the list
		textbookList.add(engbook1);

	//create the second Engineering Book 
		// set fields as from superclass
		EngineeringTextbook engbook2 = new EngineeringTextbook("Superpower", "Ross Garnaut", "584");
		//set additional field subject 
		engbook2.setSubject("Energy Technology");
		// add new book to the list
		textbookList.add(engbook2);	
		
	//create third second Engineering Book 
		// set fields as from superclass
		EngineeringTextbook engbook3 = new EngineeringTextbook("Engineering Mechanics", "Val Ivanoff", "917");
		//set additional field subject 
		engbook3.setSubject("Mechanical Engineering & Materials");
		// add new book to the list
		textbookList.add(engbook3);	

		Scanner num = new Scanner(System.in);
		int option = 0; 
		while (option!=4) {
			System.out.println("\nPossible options with the Textbook List:");
			System.out.println("------------------------------------------");
			System.out.println("1. Display available Programming Books");
			System.out.println("2. Display available Engineering Books");
			System.out.println("3. Display all available books");
			System.out.println("4. Exit the program");
			System.out.println("------------------------------------------");
			
			System.out.println("Please choose option: ");
			option = num.nextInt();
			num.nextLine();
			if (option ==1) {
					System.out.println(progbook1+ "\n" + progbook2 + "\n" + progbook3);
				}
			
			if (option==2) {
				System.out.println(engbook1+ "\n" + engbook2 + "\n" + engbook3); 
				}
			
			if (option==3) {
				System.out.println(textbookList); 
				}	
	
			if (option==4) {
					System.out.println("Program is finished. Thank you!");
				}	
			}
				

}

}