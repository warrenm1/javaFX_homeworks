package Homeworks.Homework2.Exercise2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;


public class HelloWorld extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text text1 = new Text();
        Text text2 = new Text();

        text1.setText("Hello");
        text2.setText("World");

        text1.setX(50);
        text1.setY(50);
        text2.setX(140);
        text2.setY(50);

        text1.setFont(Font.font("Old English Text MT", FontWeight.THIN,FontPosture.REGULAR,35));
        text1.setFill(Color.FORESTGREEN);
        text2.setFont(Font.font("Old English Text MT", FontWeight.THIN,FontPosture.REGULAR, 35));
        text2.setFill(Color.web("#0f2439",0.24));

        Pane pane = new Pane();

        pane.getChildren().add(text1);
        pane.getChildren().add(text2);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
