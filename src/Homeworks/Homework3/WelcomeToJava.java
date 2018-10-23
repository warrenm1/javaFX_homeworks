package Homeworks.Homework3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.ArrayList;

public class WelcomeToJava extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: #0f2439");

        Group textGroup = new Group();

        String string = "Welcome to Java";
        //String string = "I believe that we will win!!!";
        ArrayList<Character> welcome = new ArrayList();

        Circle circle = new Circle(300,250,124,Color.WHITE);
        pane.getChildren().add(circle);

        Text text = new Text("  A");
        text.setFont(Font.font("Times New Roman",150));
        text.setFill(Color.web("#0f2439"));
        pane.getChildren().add(text);

        int i = 0;
        for(char c : string.toCharArray()){
            welcome.add(i,c);
            i++;
        }

        welcome.add(welcome.size(),' ');

        double rotation = 90;
        double radius = 100;

        for(char c : welcome){
            if (!Character.isWhitespace(c)){
                Text letters = new Text(Character.toString(c));
                letters.setFont(Font.font("Old English Text MT", FontWeight.SEMI_BOLD,24));
                letters.setFill(Color.BLACK);

                Rotate rotating = new Rotate(rotation,0,radius);
                letters.getTransforms().add(rotating);

                textGroup.getChildren().add(letters);
            }
            rotation += 360 / welcome.size();
        }

        pane.getChildren().add(textGroup);

        Scene scene = new Scene(pane, 600,500);
        primaryStage.setTitle("Welcome to Java");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
