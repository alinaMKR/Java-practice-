package homeLibrary;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	//declare static variable of filename 
	private static final String FILENAME = "Library.txt";
	
	public static void main(String [] args) throws IOException{
		System.out.println("\n## Welcome to the Home Library System ##");
		//create new Library instance 
		Library lib = new Library();
		//create scanner object to accept input from user
		Scanner input = new Scanner(System.in);
		//read data from the file
		lib.readFromFile(FILENAME);
		boolean menuDisplay = true;
		//create a loop to display menu again after each operation
		while (menuDisplay) {
			//display menu using method from Library class
			System.out.println(lib.displayMenu());
			//assign user`s input to variable
			int option = input.nextInt();
			//if user chooses to add a book
			if (option==1) {
				lib.addBook();//add new book 		
			}
			//if user chooses to delete a book 
			if (option==2) {
				//display sub-menu to delete book by title/author/year/ISBN
				System.out.println(lib.displayDeletionMenu());
				int deletionOption = input.nextInt();
				if (deletionOption == 1) {//if delete by title is chosen
					lib.deleteByTitle();
				}
				if (deletionOption == 2) {//if delete by author name is chosen
					lib.deleteByAuthor();
				}
				if (deletionOption == 3) {//if delete by author year is chosen
					lib.deleteByYear();
				}
				if (deletionOption == 4) {//if delete by author ISBN is chosen
					lib.deleteByISBN();
				}
			}
			//if user chooses to search for a book
			if(option == 3) {
				System.out.println(lib.displaySearchMenu());
				int searchOption = input.nextInt();
				if (searchOption == 1) {//if search by title is chosen
					lib.searchByTitle();
				}	
				if (searchOption == 2) {//if search by author name is chosen
					lib.searchByAuthor();
				}
				if (searchOption == 3) {//if search by year is chosen
					lib.searchByYear();
				}
				if (searchOption == 4) {//if search by ISBN is chosen
					lib.searchByISBN();
				}	
			}
			//if user chooses to display all books
			if (option == 4) {
				lib.listBooks();
			}
			//if user chooses to exit the program
			if (option == 5) {
				/*save all changes before exiting, write them to file
				 * When the program is relaunched, all added information will be reloaded into the program
				 */
				lib.writeBooksToFile(FILENAME);
				System.out.println("Program is finisehd. Bye!");
				menuDisplay = false;//stop displaying menu
				System.exit(0);				
			}
		}
	}
}
