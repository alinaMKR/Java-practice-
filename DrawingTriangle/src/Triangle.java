
//import necessary classes 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;

//create Triangle class, which extends Application class 
public class Triangle extends Application {
	@Override
	public void start (Stage primaryStage) {	
		//** declare variables
		double big_triangle_side = 200;
		double small_triangle_side = 100;
		
		//variables for stage size 
		double window_width = 400;
		double window_height = 200;
		
		//coordinates for big triangle
		double X_pointA = window_width/2;
		double Y_pointA = 0;
		double X_pointB = 0.75*window_width; 
		double Y_pointB = window_height;
		double X_pointC = 0.25*window_width;
		double Y_pointC = window_height;
		
		//coordinates for small triangle 
		double X_pointN = window_width/2;
		double Y_pointN = window_height;
		double X_pointM = X_pointN + (0.25*big_triangle_side); 
		double Y_pointM = Y_pointN - (0.5*big_triangle_side);
		double X_pointL = X_pointM - small_triangle_side;
		double Y_pointL = Y_pointM;
		
		//Create Pane for triangles 
		Pane pane = new Pane();
		
		//create a big triangle using Polygon shape 
		Polygon big_triangle = new Polygon();
		big_triangle.setFill(Color.INDIGO);
		
		//set coordinates for triangle 
		big_triangle.getPoints().addAll(new Double [] {
			X_pointA, Y_pointA,
			X_pointB, Y_pointB,
			X_pointC, Y_pointC						
			});
		
		
		//create a small triangle using Polygon shape 
		Polygon small_triangle = new Polygon();
		small_triangle.setFill(Color.GOLD);
				
		//set coordinates for triangle 
		small_triangle.getPoints().addAll(new Double [] {
			X_pointN, Y_pointN,
			X_pointM, Y_pointM,
			X_pointL, Y_pointL						
			});
		
		// add triangles to pane
		pane.getChildren().add(big_triangle);
		pane.getChildren().add(small_triangle);
				
	
		//Create Scene 
		Scene scene = new Scene(pane, window_width, window_height);
		primaryStage.setTitle("Triangles");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}	
	
	//display result 
	public static void main(String[] args) {
		Application.launch(args);
		}
		
}
