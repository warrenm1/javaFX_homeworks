package Homeworks.Homework3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class HangmanGame extends Application {

    private TextField tfInput = new TextField();
    private Button button = new Button("Check");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        GridPane gridPane = new GridPane();

        Text wrongLetters = new Text();
        Text guess = new Text();
        ArrayList<String> word = new ArrayList<>();

        word.add(0,"b");
        word.add(1,"a");
        word.add(2,"c");
        word.add(3,"o");
        word.add(4,"n");

        wrongLetters.setFill(Color.RED);
        guess.setFill(Color.web("#0f2439"));

        //UI Setup
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Choose a Letter (lower case):"),0,1);
        gridPane.add(new Label("Wrong Letters:"),0,3);
        gridPane.add(new Label("Word:"),0,0);
        gridPane.add(tfInput,1,1);
        gridPane.add(wrongLetters, 1,3);
        gridPane.add(guess,1,0);
        gridPane.add(button, 1,2);
        button.setTextFill(Color.web("#0f2439"));

        //Base
        Arc arc1 = new Arc(150,600,100,75,45,90);
        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.WHITE);
        arc1.setStroke(Color.BLACK);
        arc1.setStrokeWidth(5);
        pane.getChildren().add(arc1);

        //Beams
        Line beam1 = new Line(150,525,150,50);
        beam1.setStrokeWidth(5);
        beam1.setStroke(Color.BLACK);
        pane.getChildren().add(beam1);

        Line beam2 = new Line(150,50,350, 50);
        beam2.setStrokeWidth(5);
        beam2.setStroke(Color.BLACK);
        pane.getChildren().add(beam2);

        Line beam3 = new Line(350,50,350,100);
        beam3.setStrokeWidth(5);
        beam3.setStroke(Color.BLACK);
        pane.getChildren().add(beam3);

        AtomicInteger error = new AtomicInteger();
        button.setOnAction(e -> {
            boolean letter = false;
            for(int i = 0; i < word.size(); i++){
                if(word.get(i) == guess.getText()){
                    letter = true;
                }
                else{
                    error.getAndIncrement();
                    wrongLetters.setText(wrongLetters.getText() + guess.getText());
                }
            }

            if(!letter) {
                //Head
                if (error.get() == 1) {
                    Circle head = new Circle(50);
                    head.setCenterX(350);
                    head.setCenterY(150);
                    head.setStroke(Color.BLACK);
                    head.setFill(Color.WHITE);
                    head.setStrokeWidth(5);
                    pane.getChildren().add(head);
                }

                //Body
                if (error.get() == 2) {
                    Line body = new Line(350, 200, 350, 400);
                    body.setStroke(Color.BLACK);
                    body.setStrokeWidth(5);
                    pane.getChildren().add(body);
                }

                //Arms
                if (error.get() == 3) {
                    Line armL = new Line(325, 195, 225, 295);
                    armL.setStroke(Color.BLACK);
                    armL.setStrokeWidth(5);
                    pane.getChildren().add(armL);
                }

                if (error.get() == 4) {
                    Line armR = new Line(375, 195, 475, 295);
                    armR.setStroke(Color.BLACK);
                    armR.setStrokeWidth(5);
                    pane.getChildren().add(armR);
                }

                //Legs
                if (error.get() == 5) {
                    Line legL = new Line(350, 400, 250, 500);
                    legL.setStroke(Color.BLACK);
                    legL.setStrokeWidth(5);
                    pane.getChildren().add(legL);
                }

                if (error.get() == 6) {
                    Line legR = new Line(350, 400, 450, 500);
                    legR.setStroke(Color.BLACK);
                    legR.setStrokeWidth(5);
                    pane.getChildren().add(legR);
                }

                if(error.get() == 7){
                    //TODO:Game Over Text
                }
            }
        });

        //Finished Product
        borderPane.setCenter(pane);
        borderPane.setLeft(gridPane);

        Scene scene = new Scene(borderPane,800,600);
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
