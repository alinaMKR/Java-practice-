package Task1;


//create public class Student
public class Student {

	// set private variables for student id and name 
	private String st_id;
	private String st_name;

	// create get method to return student name
	public String getName() {
	return st_name;
	}

	// create get method to return student id
	public String getId() {
	return st_id;
	}

	// create set method to set student name
	public void setName(String st_name) {
	this.st_name = st_name;
	}

	// create set method to set student name
	public void setId(String st_id) {
	this.st_id = st_id;
	}

	// create method to return string description 
	// of given student object (name and id)
	public String toString()
	{
	return "Student Name is:\t " + st_name + "\n" +
	"Student ID is:\t " + st_id ;
	}
	
	// create method to check ID validation
	public boolean isvalidId(String st_id) {
	if(st_id.length() != 6)
	return false;
	else {
	try	{
	// else catches the exception and returns false
	// if cannot parse id to long value
	Long.parseLong(st_id);
	}
	catch(NumberFormatException ex)
	{
	return false;
	}
	}
	// otherwise returns true
	return true;
	}

	// create method to check if id is unique 
	public boolean IdExists(String st_id)
	{
	if(this.st_id.equals(st_id))
	//returns true if id is already in the list
	return true;
	else
	//otherwise returns false 
	return false;
	}
}

