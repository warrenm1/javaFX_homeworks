package week6.mon;
//Discuss UML page 564
//Demo r1,r2,r3
//Discuss for loop rectangles
//Add a Hex diamond to the pane

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowRectangle extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();

        // Create rectangles and add to pane
        Rectangle r1 = new Rectangle(25, 10, 60, 30);
        r1.setStroke(Color.BLACK);
        r1.setFill(Color.WHITE);
        pane.getChildren().add(new Text(10, 27, "r1"));
        pane.getChildren().add(r1);

        Rectangle r2 = new Rectangle(25, 50, 60, 30);
        r2.setStroke(Color.web("#0F2439"));
        r2.setFill(Color.LIGHTCORAL);
        pane.getChildren().add(new Text(10, 67, "r2"));
        pane.getChildren().add(r2);

        Rectangle r3 = new Rectangle(25, 90, 60, 30);
        r3.setArcWidth(25);
        r3.setArcHeight(25);
        r3.setFill(Color.PURPLE);
        pane.getChildren().add(new Text(10, 107, "r3"));
        pane.getChildren().add(r3);

        for (int i = 0; i < 1000000; i++) {
            Rectangle r = new Rectangle(200, 50, 100, 100);
            r.setRotate(i*.000001*90);
            r.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
            r.setFill(Color.TRANSPARENT);
            pane.getChildren().add(r);
        }


        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("ShowRectangle"); // Set the stage title
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