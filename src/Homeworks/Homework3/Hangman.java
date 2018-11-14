package Homeworks.Homework3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Hangman extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

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

        //Head
        Circle head = new Circle(50);
        head.setCenterX(350);
        head.setCenterY(150);
        head.setStroke(Color.BLACK);
        head.setFill(Color.WHITE);
        head.setStrokeWidth(5);
        pane.getChildren().add(head);

        //Face
        Circle eyeL = new Circle(5);
        eyeL.setCenterX(360);
        eyeL.setCenterY(150);
        eyeL.setFill(Color.BLACK);

        Circle eyeR = new Circle(5);
        eyeR.setCenterX(340);
        eyeR.setCenterY(150);
        eyeR.setFill(Color.BLACK);

        Arc smile = new Arc(350,150,30,30,200,140);
        smile.setType(ArcType.OPEN);
        smile.setStroke(Color.BLACK);
        smile.setFill(Color.WHITE);
        smile.setStrokeWidth(5);

        Arc frown = new Arc(350,200,30,30,30,120);
        frown.setType(ArcType.OPEN);
        frown.setStroke(Color.BLACK);
        frown.setFill(Color.WHITE);
        frown.setStrokeWidth(5);

        Circle tear = new Circle(3);
        tear.setCenterX(363.5);
        tear.setCenterY(156);
        tear.setFill(Color.POWDERBLUE);

        Circle wowFace = new Circle(350, 175,15,Color.BLACK);

        Arc bigSmile = new Arc(350,155,30,30,200,140);
        bigSmile.setType(ArcType.OPEN);
        bigSmile.setFill(Color.BLACK);

        pane.getChildren().addAll(eyeL,eyeR,wowFace);

        //Body
        Line body = new Line(350,200,350,400);
        body.setStroke(Color.BLACK);
        body.setStrokeWidth(5);
        pane.getChildren().add(body);

        //Identification
        Circle circle = new Circle(360, 275, 20, Color.web("#002255"));
        pane.getChildren().add(circle);

        Text text = new Text(350,285,"Y");
        text.setFont(Font.font("Times New Roman",30));
        text.setFill(Color.WHITE);
        pane.getChildren().add(text);


        //Arms
        Line armL = new Line(325,195,225,295);
        armL.setStroke(Color.BLACK);
        armL.setStrokeWidth(5);
        pane.getChildren().add(armL);

        Line armR = new Line(375,195,475,295);
        armR.setStroke(Color.BLACK);
        armR.setStrokeWidth(5);
        pane.getChildren().add(armR);

        //Legs
        Line legL = new Line(350,400,250,500);
        legL.setStroke(Color.BLACK);
        legL.setStrokeWidth(5);
        pane.getChildren().add(legL);

        Line legR = new Line(350,400,450,500);
        legR.setStroke(Color.BLACK);
        legR.setStrokeWidth(5);
        pane.getChildren().add(legR);

        //Finished Product
        Scene scene = new Scene(pane,550,600);
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
