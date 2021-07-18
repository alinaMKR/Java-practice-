import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

//create a class to test Rectangle 
public class TestRectangle {
	public static void main(String [] args) {
		//create an ArrayList to store Rectangle objects
		ArrayList <Rectangle >rec_list = new ArrayList(); 
		
		//create a new Scanner to read input 
		Scanner input = new Scanner(System.in);
		
		// declare variable for while loop
		int num = 0;
		//while loop to display menu options 
		while (num==0) {
			//print menu
			System.out.println("\n## Rectangle Program ##");
			System.out.println("\n1. Enter rectangle details");
			System.out.println("2. Show all rectangles");
			System.out.println("3. Exit program");
			System.out.println("\nPlease enter your option: ");
			
			
			/**try statement to take input, 
			*create Rectangle and add it to the list */
			try {	
				num = input.nextInt();
				// if user enters "1"
				if (num==1) {	
					System.out.println("\nPleasExceptione enter rectangle`s height and width (in cm): ");
					float height = input.nextFloat();
					float width = input.nextFloat();
					// if user entered negative numbers 
					if (height <0 || width<0) {
						System.out.println("Invalid input. Please enter positive float numbers");
						num = 0;}
					else{ 		
						//create new Rectangle object 
						Rectangle new_rec = new Rectangle(height, width);
					
						//add rectangle to list 
						rec_list.add(new_rec);
						System.out.println("The rectangle was successfully created!");
						num = 0; }// continue - show menu 
					}
				
				// if user enters "2"
				if (num==2) {
					//sort ArrayList
					Collections.sort(rec_list);
					//print result 
					for(Rectangle o:rec_list) {
						System.out.println(o);
						num = 0;
						}		
					}
			
				// if user enters "3"
				if (num==3) {
					System.out.println("Thanks, Bye!");
					//terminate program 
					System.exit(0);
					}
				
				// if program continues operation 				
				if (num ==0){
					System.out.println("We continue");
				}
				
				// if user entered any other input 
				else {
					System.out.println("You should enter integer from 1 to 3");
					num = 0; // continue - show menu 
					} 
			}
				//catch exception if input is not a positive float number 
			catch (InputMismatchException ex) {
				System.out.println("Invalid input. Please enter correct input");
				input.nextLine();
				num=0;// continue - show menu 
				}
			
			//catch exception if Rectangle cannot be added to the list 
			catch (Exception ex) {
				System.out.println("A problem appeared while adding rectangle to array list");
				num = 0;// continue - show menu 
				}
		}
						
	}
		
}



