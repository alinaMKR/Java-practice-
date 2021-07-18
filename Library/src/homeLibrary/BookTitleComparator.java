package homeLibrary;

import java.util.Comparator;

//Create a comparator class to compare two books by their titles
public class BookTitleComparator implements Comparator<Book> {
	@Override
	    public int compare(Book b1, Book b2) {//compare books
			//return result, which one`s title value is greater(in terms of alphabetical order)
	        return b1.getTitle().compareTo(b2.getTitle());
	    }


}
