package ScreenPoints;

//import necessary utilities
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.EventHandler;

//create a class to handle events of points
public class HandlePointsEvent extends Application {
	//create a list to store points coordinates
    ArrayList<Point> points_list = new ArrayList<>();
	
	/* Since my IDE has limited JavaFX support,
	 * I need to include main method
	 */
	public static void main (String [] arqs) {
		launch(arqs);
	}
	
	@Override
	public void start(Stage primaryStage) {
		//create a group pane 
	    Group group = new Group();
	    //create static variable - radius for all points
	    final int POINT_RADIUS = 5;
	    //read data from file
	    readFile("points.txt"); 
	    //create label and set its parameters
	    Label label = new Label("");
	    label.setFont(Font.font ("Arial", 12));//set label style
	    group.getChildren().add(label);
	    //place label at the bottom of window
	    label.setLayoutX(150);
	    label.setLayoutY(370);
	    
	    //loop to get each point from the points list
	    for(Point point : points_list){
	    	//create new circle
	    	Circle new_circle = new Circle(point.x, point.y, POINT_RADIUS);
	        new_circle.setFill(Color.WHITE);//set circle color
	        
	        //add event: user hovering mouse over points
	        new_circle.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, new EventHandler<MouseEvent>() { 
	        	@Override
	        	public void handle(MouseEvent e) {
	        		//display label with text of coordinates for current hovering
	        		label.setText("x="+point.x+" y="+point.y);
	        	}
	        });
	       
	        //add event: user dragging points
	        new_circle.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
	        	@Override
	            public void handle(MouseEvent e) {
	        		//place circle to dragged location
	        		new_circle.setCenterX(e.getX());// X coordinates for new location
	                new_circle.setCenterY(e.getY());// Y coordinates for new location
	                label.setText("x="+e.getX()+" y="+e.getY());//display label as point is being dragged
	                point.x = (float) e.getX();//get new X coordinates
	                point.y = (float) e.getY();//get new Y coordinates
	             }
	        });
	         
	        //add event: user stopped dragging points
	        new_circle.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent e) {
	            	label.setText("");//reset label with empty text
	            }
	        });
	        //add circle to the group
	        group.getChildren().add(new_circle);
	    }
	    
	    
	    //create a scene and set its parameters
	    Scene scene = new Scene(group, 400, 400);
	    scene.setFill(Color.LIGHTSKYBLUE);//set background color
	    primaryStage.setTitle("Show Points");//set stage title
	    primaryStage.setScene(scene);//place created scene in the stage
	    primaryStage.show();//display the stage	    
	}

	/* Create method to read data from file
	 * and store it in the list
	 */
	private ArrayList<Point> readFile(String fileName){
		Scanner input = new Scanner(System.in);
		File new_file = new File(fileName); //reading data from this file
		String line="";
		try {
			//read file using scanner
			Scanner fileReader = new Scanner(new_file);
			//loop to read each line of the file
			while(fileReader.hasNextLine()){
				line = fileReader.nextLine();
				/* Create a list of coordinates,
				 * in file they are separated by ";"
				 * (e.g x=50; y=150)
				 */
				String coordinates_list[] = line.split(";");
				//extract x coordinates
				String xCoordinate[] = coordinates_list[0].split("=");
				//extract y coordinates
				String yCoordinate[] = coordinates_list[1].split("=");
				//create new point 
				Point new_point = new Point();
				//parse x coordinates to new point
				new_point.x = Float.parseFloat(xCoordinate[1].trim());
				//parse y coordinates to new point
				new_point.y = Float.parseFloat(yCoordinate[1].trim());
				points_list.add(new_point);//add new point to the list 	
	        }
	    } 
		//catch file not found exception 
		catch (FileNotFoundException e) {
			System.out.println("Error: This file could not be found!");
	    }
		//close scanner 
	    input.close();
	    return points_list;
	 }	
}

	//create Point class
	class Point{
		//declare x and y variables
		float x;
		float y;
		
		//create toString method
		@Override
		public String toString() {
			return "x=" + x
					+ "; y=" + y;
		}
	}

