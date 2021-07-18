package Task3;

// import necessary utilities 
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// create public class Cards 
public class Cards extends Application {
	
	@Override
	public void start (Stage primaryStage) {
		
		//set title of stage
		primaryStage.setTitle("Playing Cards Images");
		
		// create array of images
		Image cards[];
		
		// declare the size of array
		cards = new Image[54];
		
		// loop to load images into array
		for (int i = 0; i < cards.length; i++) {
			
			//load images from a file
			cards[i] = new Image ("file:D:\\CSU\\Java\\Assign3\\Assignment3\\src\\Task3\\images\\" + (i+1)+".png");
			// *to lecturer* please use your own path to see the result
        }
		
		//set random generator
        Random random = new Random();

    //*create Hbox to add images horizontally
        HBox row1 = new HBox();
        //place images in center
        row1.setAlignment(Pos.CENTER);
        row1.setSpacing(50);

      // create random index from 0 to 52 to display first 3 cards
        // add first card image to the box
        int randomNum = random.nextInt(cards.length - 2); // exclude joker
        ImageView card1 = new ImageView(cards[randomNum]);
        row1.getChildren().add(card1);

        // add second card image to the box
        randomNum = random.nextInt(cards.length - 2);
        ImageView card2 = new ImageView(cards[randomNum]);
        row1.getChildren().add(card2);

        // add third card image to the box
        randomNum = random.nextInt(cards.length - 2);
        ImageView card3 = new ImageView(cards[randomNum]);
        row1.getChildren().add(card3);
        
    //*create another Hbox to add images horizontally
        HBox row2 = new HBox();
        //place images in center
        row2.setAlignment(Pos.CENTER);
        // set space between images
        row2.setSpacing(50);
        
      //* create image view with 3 more cards
      //display joker cards index 52/53
        //view first joker card
        ImageView card4 = new ImageView(cards[52]);
        // rotate card to 45 degrees
        card4.setRotate(45);
        row2.getChildren().add(card4);
        
        //view second joker card
        ImageView card5 = new ImageView(cards[53]);
        // rotate card to 90 degrees
        card5.setRotate(90);
        row2.getChildren().add(card5);
        
      //view third joker card
        ImageView card6 = new ImageView(cards[52]);
        // rotate card to 135 degrees
        card6.setRotate(135);
        row2.getChildren().add(card6);
        
   //* create another Hbox to add images horizontally
        HBox row3 = new HBox();
        //place images in center
        row3.setAlignment(Pos.CENTER);
        row3.setSpacing(50);
        
     //* create image view with 3 more cards
        //view first card
        ImageView card7 = new ImageView(cards[0]);
        // rotate card to 135 degrees
        card7.setRotate(135);
        row3.getChildren().add(card7);
        
        //view second card
        ImageView card8 = new ImageView(cards[25]);
        // rotate card to 90 degrees
        card8.setRotate(90);
        row3.getChildren().add(card8);
        
      //view third card
        ImageView card9 = new ImageView(cards[48]);
        // rotate card to 45 degrees
        card9.setRotate(45);
        row3.getChildren().add(card9);
  

       // create Vbox to add images vertically
        VBox box = new VBox(row1, row2, row3);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(50);
          
  
        Scene scene = new Scene(box, 500, 500);
        primaryStage.setScene(scene); //add scene to the stage 
        primaryStage.show(); //display stage

    }
	// create main method
    public static void main(String[] args) {

    	Application.launch(args);

    }

}
	
