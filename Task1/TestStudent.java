package Task1;

// import necessary utilities
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//create public class TestStudent 
public class TestStudent {
	
	// create main method 
	public static void main(String[] args) {	
	String file_name;
	Scanner file = new Scanner(System.in);
	// ask user to enter file name
	System.out.print("Please enter file name with extension (e.g. 'students.txt'): ");
	file_name = file.nextLine();
	
	// create array list for this file
	ArrayList<Student> studentList = loadStudentFromFile(file_name);
	// number of students in the list 
	int num = studentList.size();
	String choice = "1";
	
	// loop continues before user exits
	while(!choice.equalsIgnoreCase("4")) {
		displayOptions();
		choice = file.nextLine();
		if(choice.equalsIgnoreCase("1")) {
			// for 'N' add new student
			addNewStudent(studentList);
			}	
		else if(choice.equalsIgnoreCase("2")) {	
			// show specific student 
			displaySingleStudent(studentList);	
			}
		else if(choice.equalsIgnoreCase("3")) {
			// show all students
			displayAllStudents(studentList);
			}
		else if(choice.equalsIgnoreCase("4")) {
			// check if any students added
			if(studentList.size() > num)
				// call method to write added students to the file
				writeNewStudentToFile(studentList, file_name, num);
				// quit
				System.out.println("Program is finished!");
				}
		
		else {
			System.out.println("Oops! Wrong Choice!");
			}
			System.out.println();
			}
	}
	
	// create method to load student from file 
	public static ArrayList<Student> loadStudentFromFile(String file_name) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		Scanner reader = null;
	try {
		// read the file
		reader = new Scanner(new File(file_name));
	}
	catch (FileNotFoundException e) {
		// display error message if file cannot be read
		System.out.println("File " + file_name + " cannot be found");
		// halt the program if file was not found
		System.exit(-1); 
	}
	
	int count = 1;
	System.out.println();
	while(reader.hasNext()) {
	String st_name = reader.next();
	String st_id = reader.next();
	Student st = new Student();
	
	boolean check = true;
	// check if id already exits in the file	
	if(checkIDExist(studentList, st_id)) {
		System.out.println("This ID number is already found in line #" + (count) + " in students.txt file");	
		check = false;
	}
	
	// check id validation 
	if(!st.isvalidId(st_id)) {
		System.out.println("Error! Invalid ID found for Student name: " + st_name + " at line #" + (count));
		check = false;
	}
	
	// if check is true new student can be added
	// otherwise, if false, skip the student
	if(check) {	
		st.setName(st_name);	
		st.setId(st_id);
		studentList.add(st);
	}
	
	// increase count by one
	count++;	
	}
	
	// return updated students list
	return studentList;
	}
	
	// create method to check if ID is unique 
	public static boolean checkIDExist(ArrayList<Student> studentList, String new_st_id) {
	// loop to check if id is found in any line
	for(int i = 0; i < studentList.size(); i++) {
		if(studentList.get(i).IdExists(new_st_id))
			// return true if id is found
			return true;
		}
		// otherwise return false
		return false;
	}
	
	// print possible options for user
	public static void displayOptions() {
	System.out.println();
	System.out.println("Options for the current file: ");
	System.out.println("1.  Add new Student to the file");
	System.out.println("2.  Display single student from the file");	
	System.out.println("3.  Display all students from the file");
	System.out.println("4.  Exit the program");
	System.out.println();
	// ask user to choose an option 
	System.out.print("Choose operation from above options (1/2/3/4): ");
	}
	
	// create method to add new student to an array list 
	public static void addNewStudent(ArrayList<Student> studentList) {
		
	// declare variables, student name, id and student itself
	String st_name;
	String st_id;
	
	boolean check = true;
	Student st = new Student();
	Scanner new_in = new Scanner(System.in);
	// ask user to enter student name
	System.out.print("Please enter new student name: ");
	// assign new name to a variable 
	st_name = new_in.nextLine();	
	// ask user to enter student id
	System.out.print("Please enter new student ID (six digits): ");
	// assign new id to a variable
	st_id = new_in.nextLine();
	
	// check if id already exists
	if(checkIDExist(studentList, st_id)) {	
		System.out.println("This ID number already exists in 'students.txt' file");	
		check = false;
	}
	
	// check if entered id is valid, contains 6 digits 
	if(!st.isvalidId(st_id)) {
		System.out.println("Wrong ID number! Please ensure it contains 6 digits");
		check = false;
	}
	
	// check if new student name and id can be set
	if(check) {
		st.setName(st_name);
		st.setId(st_id);
		studentList.add(st);
		// if check = true, print completion message
		System.out.println("New student has been added to the list");
	}	
	}
	
	// create method to show all students within the list 
	public static void displayAllStudents(ArrayList<Student> studentList) {
	Student st = new Student();
	// loop to display every line 
	for(int i = 0; i < studentList.size(); i++) {
		System.out.println(studentList.get(i) + "\n");
		}
	
	}
	
	// method to display a student based on input id
	public static void displaySingleStudent(ArrayList<Student> studentList) {
	String st_id;
	Scanner new_in = new Scanner(System.in);
	// ask user for input: student ID
	System.out.print("Please enter studet ID: ");
	st_id = new_in.nextLine();
	
	boolean check = false;
	// loop to find id in a line 
	for(int i = 0; i < studentList.size(); i++) {
		// if id is found
		if(studentList.get(i).getId().equals(st_id)) {
			System.out.println(studentList.get(i));
			check = true;
			break;
			}
		}
	
	// if check == false
	if(!check)	{
		System.out.println("There is no such ID in the list");
		}	
	}
	
	
	// create method to write new student to the file
	public static void writeNewStudentToFile(ArrayList<Student> studentList, String file_name, int number) {
	
	// call buffered writer 
	BufferedWriter writer = null;
	
	try {
		writer = new BufferedWriter(new FileWriter(file_name, true));
		writer.write("\n");
		// loop to write every new student name and id in one line 
		for(int i = number; i < studentList.size(); i++)	{
			writer.write(studentList.get(i).getName() + " " + studentList.get(i).getId() + "\n");	
			}
		writer.flush();	
	}
	
	// if exception is raised 
	catch (IOException e) {
		return;
		}
	}
	
	}
