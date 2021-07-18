package homeLibrary;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Book implements Serializable {
	//declare variables 
	public String title;
	public String author;
	public String year;
	public String isbn;
	
	//create constructor
	public Book(String title, String author, String year, String isbn) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;	
	}
	
	//getter for title
	public String getTitle() {
		return this.title;
	}
	
	//getter for author
	public String getAuthor() {
		return this.author;
	}
	
	//getter for title
	public String getYear() {
		return this.year;
	}
	
	//getter for isbn
	public String getISBN() {
		return this.isbn;
	}
	
	//create toString method to display book details
	public String toString() {
		StringBuilder book = new StringBuilder();
		book.append("Title: ").append(title).append("\n")
			.append("Author: ").append(author).append("\n")
			.append("Year: ").append(year).append("\n")
			.append("ISBN: ").append(isbn);
		//print out book details
		return book.toString();
	}
	
	public String toStringToFile()
	{
	return(title + "," + author + "," + year + "," + isbn);
	}
	
	
	

}
