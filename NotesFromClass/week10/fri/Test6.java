//The OK button is clicked
package week10.fri;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Test6 extends Application {
          @Override // Override the start method in the Application class
          public void start(Stage primaryStage) {
            Button btOK = new Button("OK");
           
            btOK.setOnAction(new EventHandler<ActionEvent>() {
              public void handle(ActionEvent e) {
                System.out.println("The OK button is clicked");
              }
            });
            
            Scene scene = new Scene(btOK, 200, 250);
            primaryStage.setTitle("MyJavaFX"); // Set the stage title
            primaryStage.setScene(scene); // Place the scene in the stage
            primaryStage.show(); // Display the stage
          }

          /**
    * The main method is only needed for the IDE with limited JavaFX
    * support. Not needed for running from the command line.
    */
          public static void main(String[] args) {
            launch(args);
          }
        }
