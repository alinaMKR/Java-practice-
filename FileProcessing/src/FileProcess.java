
//import Java File class 
import java.io.*;
import java.io.IOException;

public class FileProcess {
	//main method throws possible exceptions 
	public static void main (String [] args) throws FileNotFoundException, IOException {
		
		//create  a new object in File class 
		java.io.File new_file = new java.io.File("1.txt");
		if (!new_file.exists()) {
			//Error message if file does not exist 
			System.out.println("This file does not exist");
			System.exit(0);
		}
		
		//create new FileInputStream, and readers to work with file components
		FileInputStream file_stream = new FileInputStream(new_file);
		InputStreamReader new_input = new InputStreamReader(file_stream);
		BufferedReader file_reader = new BufferedReader(new_input);
		
		//declare variables
		String line;
		int all_num = 0;
		int char_num = 0;
		int space_num = 0;
		int word_num = 0;
		
		// Loop for every line within the file
		while ((line = file_reader.readLine()) != null) {
			//count all characters including spaces 
			all_num += line.length();
			
			//create a list of white spaces
			String [] word_list = line.split("\\s+");
			
			//count number of words       
            word_num += word_list.length; 
		}
		
		//count number of white spaces in file 
		space_num += word_num -1; //exclude last space 
		
		//count characters number excluding spaces 
		char_num = all_num - space_num; 
		//close the file 
		file_reader.close();

		// print the result 
		System.out.println("Number of characters excluding white spaces is: " +char_num);
		
	}

}
