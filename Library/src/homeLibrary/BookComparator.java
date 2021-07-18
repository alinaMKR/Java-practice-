package homeLibrary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Create Book class to use comparator, i.e to sort a list by multiple
 * * attributes by chaining a sequence of comparators of individual fields
* together (further title, author name, year)
 */
public class BookComparator implements Comparator<Book> {
	//create a books_list to store and sort all books 
	private List<Comparator<Book>> book_list;
	
	//create comparator method to pass a list and make it a comparator
	@SafeVarargs
	public BookComparator(Comparator<Book>... comparators) {
		this.book_list = Arrays.asList(comparators);
		}
	/* create compare method to compare all books,
	 * checking 2 books at a time
	 */
	@Override
	public int compare(Book b1, Book b2) {
		//check all books from the list
		for (Comparator<Book> comparator : book_list) {
			int result = comparator.compare(b1, b2);//compare them 
			if (result != 0) {
				return result;//return result, which one`s value is greater
				}
			}
		return 0;
		}
	}
