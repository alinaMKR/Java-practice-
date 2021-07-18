package homeLibrary;

public class ISBNFormatError {
	//declare ISBN string variable
	private String isbn;
  
	//create constructor 
	public ISBNFormatError(String isbn) {
		this.isbn = isbn;
	}
  
	//create method to check for valid ISBN
	public boolean checkValidity() {
		//declare boolean variable to valid the length of ISBN
		boolean isbnLength = false;
		//check if ISBN consists of 10 characters
		if(isbn.length() == 10) {
			isbnLength = true;
		}
		//create boolean variable to valid all characters as digits
		boolean digitsChar = true;
		//loop to check every character of ISBN string
		for(int i = 0; i < isbn.length(); i++) {
			//check is current character is digit
			if(!Character.isDigit(isbn.charAt(i))) {
				//return false if character is not a digit 
				digitsChar = false;
				//finish the method if character is not a digit
				break;
			}
		}
		//return true/false for correct length and characters 
		return(isbnLength && digitsChar);
	}
}
