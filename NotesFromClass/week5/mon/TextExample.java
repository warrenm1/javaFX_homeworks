package week5.mon;

/**
 * Run App, play with Fonts, sizes, and colors
 * Add Text2, underline, strikethrough, linespacing
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

public class TextExample extends Application {
    @Override
    public void start(Stage stage) {
        //Creating a Text object
        Text text = new Text();

        //Setting the text to be added.
        text.setText("Hello how are you.  My name is Andy Brim, and I am a PhD Student at Utah State University, go Aggies!!!!");

        //setting the position of the text
        text.setX(50);
        text.setY(50);


        Text text2 = new Text();
        text2.setUnderline(true);
        text2.setX(50);
        text2.setY(100);
        text2.setText("I am well");
        text2.setStrikethrough(true);


        //Setting font to the text
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setFill(Color.AQUA);
        //Creating a Group object
        Group root = new Group(text);



        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);


        root.getChildren().add(text2);

        //Setting title to the Stage
        stage.setTitle("Sample Application");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
