package homeLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner; 

@SuppressWarnings("serial")
public class Library implements Serializable {
	//create array list to store books
	ArrayList <Book> books_list = new ArrayList<Book>();
	//create scanner to accept input from user
	Scanner input = new Scanner(System.in);
	
	//create a non-argument constructor for Library class
	public Library() {
		this.books_list = new ArrayList<>();
	}
	
	//create method to display menu 
	public String displayMenu() {
		//create new string builder 
		StringBuilder menu = new StringBuilder();
		//build menu text
		menu.append("\nPlease select one of the following options:\n")
			.append("1. Add a new book\n")
			.append("2. Delete a book\n")
			.append("3. Search for a book\n")
			.append("4. Display all books\n")
			.append("5. Exit\n")
			.append("Please enter your choice (1-5): ");
		//return menu with appropriate format
		return menu.toString();		
	}
	
	//create method to display sub-menu to delete a book
	public String displayDeletionMenu() {
		//create new string builder
		StringBuilder subMenu = new StringBuilder();
		//build sub-menu text
		subMenu.append("\nChoose an option to delete book by:\n")
			.append("1. Title\n")
			.append("2. Author\n")
			.append("3. Year\n")
			.append("4. ISBN\n")
			.append("Please enter your choice (1-4): ");
		//return sub-menu with appropriate format
		return subMenu.toString();
	}
	
	//create method to display sub-menu to search for a book
	public String displaySearchMenu() {
		//create new string builder
		StringBuilder subMenu = new StringBuilder();
		//build sub-menu text
		subMenu.append("\nChoose an option to search for book by:\n")
			.append("1. Title\n")
			.append("2. Author\n")
			.append("3. Year\n")
			.append("4. ISBN\n")
			.append("Please enter your choice (1-4): ");
		//return sub-menu with appropriate format
		return subMenu.toString();
	}
	
	//create method to add new book to the list
	public ArrayList<Book> addBook() throws IOException{
		/*Ask user to enter book details,
		 * display error message if user entered empty
		 * spaces, year other than of 4 digits and 
		 * ISBN other than of 10 digits
		 */
		System.out.println("\n# Add new book #:\n");
		System.out.println("Please enter the title of the book: ");
		String title = input.nextLine();
		//Loop until user stop entering empty Title 
		while(title.equals("")) {
			System.out.println("Error: Title cannot be empty!");
			System.out.println("Please enter the title of the book: ");
			title = input.nextLine();
		}
		System.out.println("Please enter the author of the book: ");
		String author = input.nextLine();
		//Loop until user stop entering empty Author 
		while(author.contentEquals("")) {
			System.out.println("Error: Author name cannot be empty!");
			System.out.println("Please enter the author of the book: ");
			author = input.nextLine();	
		}
		System.out.println("Please enter the year of publication: ");
		String year = input.nextLine();
		// Loop until user enters correct Year format
		while(year.length() != 4) {
			System.out.println("Error: Year should contnain 4 digits");
			System.out.println("Please enter the year of publication: ");
			year = input.nextLine();
		}
		System.out.println("Please enter the ISBN  number: ");
		String isbn = input.nextLine();
		//create new object of ISBNFormatError class
		ISBNFormatError isbnErr = new ISBNFormatError(isbn);
		//check is ISBN has 10 digits
		if (!isbnErr.checkValidity()) {
			System.out.println("ISBNFormatError: ISBN should be 10 digits!");
			System.out.println("Please enter the ISBN  number: ");
			isbn = input.nextLine();
		}
		//check if book with this ISBN already exits in the list
		if (checkExistenceOfISBN(isbn) != -1) {
			System.out.println("Book with this ISBN is already in the library!");
		}
		else {
			try {
				//create new book based on entered data
				Book new_book = new Book(title, author, year, isbn);
				//add book to the list 
				books_list.add(new_book);
				//display message of successful addition 
				System.out.println("New book has been successfully added");
			}
			//catch exception if new book cannot be created and added to the list
			catch (Exception e) {
				// print appropriate message
				System.out.println("Error: Cannot create a book with this format!");
			}
		}
		//return books list
		return books_list;
	}
	
	// create a method to delete book by ISBN
	public ArrayList<Book> deleteByISBN() {
		System.out.println("\n# Delete by ISBN #\n"
				+ "Enter ISBN: ");
		String isbn = input.nextLine();
		//create new object of ISBNFormatError class
		ISBNFormatError isbnErr = new ISBNFormatError(isbn);
		//check is ISBN has 10 digits
		if (!isbnErr.checkValidity()) {
			System.out.println("ISBNFormatError: ISBN should be 10 digits!");
			System.out.println("Please enter the ISBN  number: ");
			isbn = input.nextLine();
		}
		//loop to check each book in the list 
		int k = 0;
        for(Book b: books_list) {
        	/* Since ISBN is unique, whenever ISBN matches the search,
        	 * print out book details and ask user to confirm deletion
        	 */
            if(isbn.equals(b.getISBN())) {
            	System.out.println(b.toString());
            	String answer = null;
            	System.out.println("\nDo you want to delete this book? (Y/N): ");
            	answer = input.nextLine();
            	if (answer.equalsIgnoreCase("Y")) {
            		books_list.remove(b);// delete the book 
            		System.out.println("The book has been deleted from list!");// print confirmation
            		k = 1;
            		break;//finish method
            	}
            	else {//if user doesn't want to delete this book
            		System.out.println("Book has not been deleted. returning to main menu!");
            	}
            }
        }
        //if book with passed ISBN does not exist in the Library
        if (k != 1) {
           	System.out.println("There are no such books in your Library!");
        }
            return null;
        }
		
	
	//create a method to delete book by title
	public ArrayList<Book> deleteByTitle(){
		System.out.println("\n# Delete by title #\n"
				+ "Enter title: ");
		String title = input.nextLine();
		//Loop until user stop entering empty Title 
		while(title.equals("")) {
			System.out.println("Error: Title cannot be empty!");
			System.out.println("Please enter the title of the book: ");
			title = input.nextLine();
		}		
		//create array list (of  books w/passed title) to store books to delete 
		ArrayList<Book> delete_list = new ArrayList<Book>();
		int k = 0;
        for(Book b: books_list) {
        	//if entered title is the same as title from available books
            if(title.equalsIgnoreCase(b.getTitle())) {
                delete_list.add(b); //add this book to new list for deletion
                /* change k variable, so the system knows at least
                 *  one book with the same title has been found
                 */
                k = 1;
            }
        }
        //use collections and comparator classes to sort deletion array list
        Collections.sort(delete_list, new BookComparator(
        		//based first on title, then author and year
        		new BookTitleComparator(),
                new BookAuthorComparator(),
                new BookYearComparator())
    		);
        //if at least one book has match 
        if (k == 1) {
        	System.out.println("\nThere are following books based on your search:");
        	/* create i variable, use it as a number of book (as a counter),
        	 * which has the same title as passed to the method.
        	 * It is needed if several books with same title or
        	 * author name are presented in library
        	 */
        	int i = 1;
        	//loop to print all books that match 
        	for (Book book : delete_list) {
        		System.out.println("\n#" + i);// print number of book
        		System.out.println(book);// print book itself
        		i++;// increase i by 1
        	}
        	//ask user which of the displayed books will be deleted
        	System.out.println("\nEnter a number of book you wish to delete: ");
        	try {
        		int bookNum = input.nextInt();//get number of chosen book
        		/* get index of chosen book, which is: book number - 1,
        		 * then delete this book by unique ISBN
        		 */
        		String isbnDel = delete_list.get(bookNum-1).getISBN();
        		for (Book bk: books_list) {
        			//if ISBN of book from deletion list is same as in books list library - delete it
        			if (isbnDel.equals(bk.getISBN())) {
        				books_list.remove(bk);
        				System.out.println("The book has been deleted from list!");// print confirmation 
        				break;//finish method 
        			}
        		}
        	}
        	//catch exception if wrong number entered
        	catch (IndexOutOfBoundsException iobe) {
        		System.out.println("Error: Wrong number of book entered!"
        				+ "\nReturning to main menu");
        	}
        	//catch exception if not a number was entered
        	catch (InputMismatchException ime) {
        		System.out.println("Error: Number of book should be a digit!"
        				+ "\nReturning to main menu");
        	}
        }
        //if no books with the same title have been found
        else {
        	//print appropriate message
            System.out.println("There are no such books in your Library!");
        }
        return books_list;
	}
	
	/* Following methods deleteByAuthor and deleteByYear use
	 * same logic as deleteByTitle method
	 */
	public ArrayList<Book> deleteByAuthor()  {
		System.out.println("\n# Delete by author name #\n"
				+ "Enter author: ");
		String author = input.nextLine();
		//Loop until user stop entering empty Author
		while(author.contentEquals("")) {
			System.out.println("Error: Author name cannot be empty!");
			System.out.println("Please enter the author of the book: ");
			author = input.nextLine();	
		}
		ArrayList<Book> delete_list = new ArrayList<Book>();
		int k = 0;
        for(Book b: books_list) {
            if(author.equalsIgnoreCase(b.getAuthor())) {
                delete_list.add(b);   
                k = 1;
            }
        }
        Collections.sort(delete_list, new BookComparator(
        		new BookTitleComparator(),
        		new BookAuthorComparator(),
        		new BookYearComparator())
    		);
        if (k == 1) {
        	System.out.println("\nThere are following books based on your search:");
        	int i = 1;
        	for (Book book : delete_list) {
        		System.out.println("\n#" + i);
        		System.out.println(book);
        		i++;
    		}
        	System.out.println("\nEnter a number of book you wish to delete: ");
        	try {
        		int bookNum = input.nextInt();
        		String isbnDel = delete_list.get(bookNum-1).getISBN();
        		for (Book bk: books_list) {
        			//if ISBN of book from deletion list is same as in books list library - delete it
        			if (isbnDel.equals(bk.getISBN())) {
        				books_list.remove(bk);
        				System.out.println("The book has been deleted from list!");// print confirmation 
        				break;//finish method 
        			}
        		}
        	}
        	catch (IndexOutOfBoundsException iobe) {
        		System.out.println("Error: Wrong number of book entered!"
        				+ "\nReturning to main menu");
        	}
        	catch (InputMismatchException ime) {
        		System.out.println("Error: Number of book should be a digit!"
        				+ "\nReturning to main menu");
        	}
        }
    	else {
    		//print appropriate message
    		System.out.println("There are no such books in your Library!");
    	}
        return books_list;
	}

	public ArrayList<Book> deleteByYear()  {
		System.out.println("\n# Delete by year #\n"
				+ "Enter year: ");
		String year = input.nextLine();
		// Loop until user enters correct Year format
		while(year.length() != 4) {
			System.out.println("Error: Year should contnain 4 digits");
			System.out.println("Please enter the year of publication: ");
			year = input.nextLine();
		}
		ArrayList<Book> delete_list = new ArrayList<Book>();
		int k = 0;
        for(Book b: books_list) {
            if(year.equalsIgnoreCase(b.getYear())) {
                delete_list.add(b);   
                k = 1;
            }
        }
        Collections.sort(delete_list, new BookComparator(
        		new BookTitleComparator(),
        		new BookAuthorComparator(),
        		new BookYearComparator())
    		);
        if (k == 1) {
        	System.out.println("\nThere are following books based on your search:");
        	int i = 1;
        	for (Book book : delete_list) {
        		System.out.println("\n#" + i);
        		System.out.println(book);
        		i++;
    		}
        	System.out.println("\nEnter a number of book you wish to delete: ");
        	try {
	        	int bookNum = input.nextInt();
	        	String isbnDel = delete_list.get(bookNum-1).getISBN();
	        	for (Book bk: books_list) {
	        		//if ISBN of book from deletion list is same as in books list library - delete it
	        		if (isbnDel.equals(bk.getISBN())) {
	        			books_list.remove(bk);
	        			System.out.println("The book has been deleted from list!");// print confirmation 
	        			break;//finish method 
	        		}
	        	}
        	}
        	//catch exception if wrong number entered
        	catch (IndexOutOfBoundsException iobe) {
        		System.out.println("Error: Wrong number of book entered!"
        				+ "\nReturning to main menu");
        	}
        	//catch exception if not a number was entered
        	catch (InputMismatchException ime) {
        		System.out.println("Error: Number of book should be a digit!"
        				+ "\nReturning to main menu");
        	}     	
        }
    	else {
    		//print appropriate message
    		System.out.println("There are no such books in your Library!");
    	}
        return books_list;
	}
	
	//create a method to search for book by book`s title
	public ArrayList<Book> searchByTitle() {
		System.out.println("\n# Search by title #\n"
				+ "Enter title: ");
			String title = input.nextLine();
		//Loop until user stop entering empty Title 
		while(title.equals("")) {
			System.out.println("Error: Title cannot be empty!");
			System.out.println("Please enter the title of the book: ");
			title = input.nextLine();
		}		
        int i = 0;
      //loop to check each book in the list
		for(Book b: books_list) {
            if(title.equalsIgnoreCase(b.getTitle())) {//check if entered title equals to current book`s title
                System.out.println(b.toString()+ "\n");// print it if it is the same
                /* change i variable, so the system knows at least
                 *  one book with the same title has been found
                 */
                i = 1;
            }
        }
		//if none of the books with this title has been found
        if(i == 0) {
        	//print appropriate message
            System.out.println("There are no such books in your Library!");
        }
        return null;
	}
	
	//create a method to search for book by author`s name
	public ArrayList<Book> searchByAuthor() {
		System.out.println("\n# Search by author #\n"
				+ "Enter author: ");
		String author = input.nextLine();
		//Loop until user stop entering empty Author
		while(author.contentEquals("")) {
			System.out.println("Error: Author name cannot be empty!");
			System.out.println("Please enter the author of the book: ");
			author = input.nextLine();	
		}
        int i = 0;
        //loop to check each book in the list
		for(Book b: books_list) {
            if(author.equalsIgnoreCase(b.getAuthor())) {//check if entered name equals to current book`s author name
                System.out.println(b.toString()+ "\n");// print it if it is the same
                /* change i variable, so the system knows at least
                 *  one book with the same name has been found
                 */
                i = 1;
            }
        }
		//if none of the books with this author`s name has been found
		if(i == 0) {
			//print appropriate message
            System.out.println("There are no such books in your Library!");
        }
        return null;
	}
	
	//create a method to search for book by year
	public ArrayList<Book> searchByYear() {
		System.out.println("\n# Search by year #\n"
				+ "Enter year: ");
		String year = input.nextLine();
		while(year.length() != 4) {
			System.out.println("Error: Year should contnain 4 digits");
			System.out.println("Please enter the year of publication: ");
			year = input.nextLine();
		}
		int i = 0;
		//loop to check each book in the list
        for(Book b: books_list) {
            if(year.equals(b.getYear())) {//check if entered year equals to current book`s year
                System.out.println(b.toString()+ "\n");// print it if it is the same
                /* change i variable, so the system knows at least
                 *  one book with the same year has been found
                 */
                i = 1;
            }
        }
        //if none of the books with this year has been found
        if(i == 0) {
        	//print appropriate message
            System.out.println("There are no such books in your Library!");
        }
        return null;
	}
	
	//create a method to search for book by ISBN
	public ArrayList<Book> searchByISBN() {
		System.out.println("\n# Search by ISBN #\n"
				+ "Enter ISBN: ");
		String isbn = input.nextLine();
		//create new object of ISBNFormatError class
		ISBNFormatError isbnErr = new ISBNFormatError(isbn);
		//check id ISBN has 10 digits
		if (!isbnErr.checkValidity()) {
			System.out.println("ISBNFormatError: ISBN should be 10 digits!");
			System.out.println("Please enter the ISBN  number: ");
			isbn = input.nextLine();
		}
		int i = 0;
		//loop to check each book in the list
        for(Book b: books_list) {
            if(isbn.equals(b.getISBN())) { //check if entered ISBN equals to current book`s ISBN
                System.out.println(b.toString()+ "\n");// print it if it is the same
                /* change i variable, so the system knows at least
                 *  one book with the same ISBN has been found
                 */
                i = 1;
            }
        }
        //if none of the books with this ISBN has been found
        if(i == 0) {
        		//print appropriate message
            	System.out.println("There are no such books in your Library!");
        }		
        return null;
	}
	
	//Create method to list all books 
	public void listBooks() {
		System.out.println("\n# List all books #:");
		if (books_list.isEmpty()) {
			System.out.println("There are no books in Library");
		}
		/* If list is not empty, display all books
		 * in alphabetical order, based on title, author name, year,
		 * using Collections and created classes implementing Comparator
		 */
		else {
			Collections.sort(books_list, new BookComparator(
                new BookTitleComparator(),//book`s titles sorted in alphabetical order 
                new BookAuthorComparator(),//book`s authors names sorted in alphabetical order 
                new BookYearComparator())//book`s publishing years sorted in alphabetical order 
			);
			System.out.println("\nThere are following books in the library:\n");
			//loop to display each book in the list
			for (Book b : books_list) {
				System.out.println(b.toString()+"\n");
			}
		}
		
	}
	
	/*create a method to check if ISBN already exits in the list,
	 * since ISBN should be unique, this method 
	 * is need if user wants to add new book
	 */
	private int checkExistenceOfISBN(String isbn) {
		int index = -1;
		//loop to check each book in the list
		for (int i = 0; i<books_list.size(); i++) {
			if (books_list.get(i).getISBN().equals(isbn)) {
				//returns -1 if this ISBN already exists
				index = i;
				break;
			}
		}
		return index;
	}
	
	/* Create method to read data from file.
	 * As data in file presented like: Title, Author, Year, ISBN;
	 * there is need to separate attributes by comma
	 * and assign them to book variables
	 */
	public void readFromFile(String fileName) {
		try {
			File new_file = new File(fileName);
			Scanner fileReader = new Scanner(new_file);
			while(fileReader.hasNextLine()) {
				/*books attributes are separated by comma in the file
				 * (e.g. War and Peace,Leo Tolstoy,1867,0099512246)
				 * therefore to store data as variables lines will be trimmed
				 * and separated by commas, and then passed to books_list
				 */
				String[] bookAttributes = fileReader.nextLine().trim().split(",");
				String title = bookAttributes[0];
				String author = bookAttributes[1];
				String year = bookAttributes[2];
				String isbn = bookAttributes[3];
				Book new_book = new Book(title, author, year, isbn);
				books_list.add(new_book);
			}
		fileReader.close();
		}
		//throw exception if this file does not exist
		catch(FileNotFoundException ex){
			System.out.println("\nThe file has not been found! Program will be terminated");
			System.exit(0);
		}
	}
	
	/* Create a method to save all changes to the file,
	 * this method is invoked when user exits the program,
	 * user will get a messages about saving changes to file before
	 * program will be terminated
	 */
	public void writeBooksToFile(String fileName){
		try {
			FileWriter fileWriter = new FileWriter(new File(fileName));
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for(Book b : books_list) {
				//write all strings from books_list to the file
				printWriter.write(b.toStringToFile() + System.lineSeparator());
			}	  
			printWriter.flush();
			fileWriter.close();
			printWriter.close();
			System.out.println("\nAll changes have been saved to " + fileName);
		} 
		//if data cannot be written to the file throw exception 
		catch (IOException ex) {
			System.out.println("Error in writing to " + fileName + "! Exiting..");
			System.exit(0);
		}
	}	

}
