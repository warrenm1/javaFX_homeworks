package week6.mon;

//Discuss UML on page 566
//Demo for loop, decrease to 4 loops, increase
//Change fill colors
//try and make a circle

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class ShowEllipse extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();


        Ellipse e1 = new Ellipse(150, 300, 50, 100);
        e1.setStroke(Color.color(Math.random(), Math.random(),
                Math.random()));
        e1.setFill(Color.WHITE);
        pane.getChildren().add(e1);

        for (int i = 0; i < 16; i++) {
            // Create an ellipse and add it to pane
            Ellipse e2 = new Ellipse(150, 100, 100, 50);
            e2.setStroke(Color.color(Math.random(), Math.random(),
                    Math.random()));
            e2.setFill(Color.WHITE);
            e2.setRotate(i * 180 / 10);
            pane.getChildren().add(e2);
        }

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("ShowEllipse"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}