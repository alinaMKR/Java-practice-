package Task2;

// create abstract class called Textbook
public abstract class Textbook {
	
	//declare data fields
	protected String title;
	protected String author;
	protected String pages;
	
	// construct a default textbook
	protected Textbook() {
		super();
	}
	
	//construct Textbook with title, author and pages values
	protected Textbook(String  title, String author, String pages2) {
		this.title = title;
		this.author = author;
		this.pages = pages2;
		}
	
	// return title
	public String getTitle() {
		return title;
	}
	
	// set a new title
	public void setTitle(String title) {
		this.title = title;	
	}
	
	// return author 
	public String getAuthor() {
		return author;
	}
	
	// set a new author 
	public void setAuthor(String author) {
		this.author = author;
	}
	
	// return number of pages
	public String getPages() {
		return pages;
	}
	
	// set new number of pages 
	public void setPages(String pages) {
		this.pages = pages;
	}

	@Override
	//toString() method to print object representation
	public String toString() {
		return "Book title: " + title + "\n Author: " 
				+ author + "\n Number of pages: " + pages;
	}
}
	
	//create subclass ProgrammingTextbook
	class ProgrammingTextbook extends Textbook {
		private String language;
		
		// default constructor
		public ProgrammingTextbook() {
			super();		
		}
	
		// construct Programming Textbook with values from superclass
		public ProgrammingTextbook (String title, String author, String string) {
			super(title, author, string);
		}
		
		// construct Programming Textbook with additional language value 
		public ProgrammingTextbook (String language) {
			super();
			this.language = language;
		}
		
		// get method to return language 
		public String getLanguage() {
			return language;
		}
		
		// set a new language 
		public void setLanguage(String language) {
			this.language = language;
		}
	
		@Override
		//toString() method to print object representation 
		public String toString() {
			return "\n Book title: " + title + "\n Author: " + author + 
					"\n Number of pages: " + pages + "\n Language: " + language + "\n ___________________";
		}	
	}
	
	// create subclass EngineeringTextbook
	class EngineeringTextbook extends Textbook {
		private String subject; 
		
		// default constructor
		public EngineeringTextbook() {
			super();
			}
		
		
		// construct Programming Textbook with values from superclass
		public EngineeringTextbook(String title, String author, String pages) {
			super(title, author, pages);
			}
		
		// construct Programming Textbook with additional subject value 
		public EngineeringTextbook(String subject) {
			super();
			this.subject = subject;
			}
		
		// get method to return subject 
		public String getSubject() {
			return subject; 
			}
		
		//set new subject
		public void setSubject(String subject) {
			this.subject = subject;
			}
		
		@Override
		//toString() method to print object representation
		public String toString() {
			return "\n Book title: " + title + "\n Author: " + author + 
					"\n Number of pages: " + pages + "\n Subject: " + subject + "\n ___________________";
			}
		
		
	}

