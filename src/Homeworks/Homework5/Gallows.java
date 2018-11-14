package Homeworks.Homework5;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Gallows extends Pane {
    private Arc arc1 = new Arc(150,600,100,75,45,90);
    private Line beam1 = new Line(150,525,150,50);
    private Line beam2 = new Line(150,50,350,50);
    private Line beam3 = new Line(350,50,350,100);


    public Gallows(){
        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.WHITE);
        arc1.setStroke(Color.BLACK);
        arc1.setStrokeWidth(5);

        beam1.setStrokeWidth(5);
        beam1.setStroke(Color.BLACK);

        beam2.setStrokeWidth(5);
        beam2.setStroke(Color.BLACK);

        beam3.setStrokeWidth(5);
        beam3.setStroke(Color.BLACK);

        this.getChildren().addAll(arc1,beam1,beam2,beam3);
    }
}