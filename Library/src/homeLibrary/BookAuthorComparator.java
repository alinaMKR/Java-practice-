package homeLibrary;

import java.util.Comparator;

// Create a comparator class to compare two books by their authors
public class BookAuthorComparator implements Comparator<Book> {
	@Override
    public int compare(Book b1, Book b2) {//compare books
		//return result, which one`s authors value is greater(in terms of alphabetical order)
        return b1.getAuthor().compareTo(b2.getAuthor());
    }
}
