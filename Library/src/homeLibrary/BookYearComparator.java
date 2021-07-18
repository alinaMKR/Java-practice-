package homeLibrary;

import java.util.Comparator;

//Create a comparator class to compare two books by their years of publication
public class BookYearComparator implements Comparator<Book> {
	@Override
    public int compare(Book b1, Book b2) {//compare books
		//return result, which one`s year value is greater(in terms of numerical order)
        return b1.getYear().compareTo(b2.getYear());
    }

}
