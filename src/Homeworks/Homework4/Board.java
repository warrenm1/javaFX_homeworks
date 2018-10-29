package Homeworks.Homework4;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Board extends Pane {
    //Row 1
    private Circle c11 = new Circle(50, 50, 20, Color.WHITE);
    private Circle c12 = new Circle(100, 50, 20, Color.WHITE);
    private Circle c13 = new Circle(150, 50, 20, Color.WHITE);
    private Circle c14 = new Circle(200, 50, 20, Color.WHITE);
    private Circle c15 = new Circle(250, 50, 20, Color.WHITE);
    private Circle c16 = new Circle(300, 50, 20, Color.WHITE);
    private Circle c17 = new Circle(350, 50, 20, Color.WHITE);
    //Row 2
    private Circle c21 = new Circle(50, 100, 20, Color.WHITE);
    private Circle c22 = new Circle(100, 100, 20, Color.WHITE);
    private Circle c23 = new Circle(150, 100, 20, Color.WHITE);
    private Circle c24 = new Circle(200, 100, 20, Color.WHITE);
    private Circle c25 = new Circle(250, 100, 20, Color.WHITE);
    private Circle c26 = new Circle(300, 100, 20, Color.WHITE);
    private Circle c27 = new Circle(350, 100, 20, Color.WHITE);
    //Row 3
    private Circle c31 = new Circle(50, 150, 20, Color.WHITE);
    private Circle c32 = new Circle(100, 150, 20, Color.WHITE);
    private Circle c33 = new Circle(150, 150, 20, Color.WHITE);
    private Circle c34 = new Circle(200, 150, 20, Color.WHITE);
    private Circle c35 = new Circle(250, 150, 20, Color.WHITE);
    private Circle c36 = new Circle(300, 150, 20, Color.WHITE);
    private Circle c37 = new Circle(350, 150, 20, Color.WHITE);
    //Row 4
    private Circle c41 = new Circle(50, 200, 20, Color.WHITE);
    private Circle c42 = new Circle(100, 200, 20, Color.WHITE);
    private Circle c43 = new Circle(150, 200, 20, Color.WHITE);
    private Circle c44 = new Circle(200, 200, 20, Color.WHITE);
    private Circle c45 = new Circle(250, 200, 20, Color.WHITE);
    private Circle c46 = new Circle(300, 200, 20, Color.WHITE);
    private Circle c47 = new Circle(350, 200, 20, Color.WHITE);
    //Row 5
    private Circle c51 = new Circle(50, 250, 20, Color.WHITE);
    private Circle c52 = new Circle(100, 250, 20, Color.WHITE);
    private Circle c53 = new Circle(150, 250, 20, Color.WHITE);
    private Circle c54 = new Circle(200, 250, 20, Color.WHITE);
    private Circle c55 = new Circle(250, 250, 20, Color.WHITE);
    private Circle c56 = new Circle(300, 250, 20, Color.WHITE);
    private Circle c57 = new Circle(350, 250, 20, Color.WHITE);
    //Row 6
    private Circle c61 = new Circle(50, 300, 20, Color.WHITE);
    private Circle c62 = new Circle(100, 300, 20, Color.WHITE);
    private Circle c63 = new Circle(150, 300, 20, Color.WHITE);
    private Circle c64 = new Circle(200, 300, 20, Color.WHITE);
    private Circle c65 = new Circle(250, 300, 20, Color.WHITE);
    private Circle c66 = new Circle(300, 300, 20, Color.WHITE);
    private Circle c67 = new Circle(350, 300, 20, Color.WHITE);

    public Board() {
        this.getChildren().add(getCircle(c11));
        this.getChildren().add(getCircle(c12));
        this.getChildren().add(getCircle(c13));
        this.getChildren().add(getCircle(c14));
        this.getChildren().add(getCircle(c15));
        this.getChildren().add(getCircle(c16));
        this.getChildren().add(getCircle(c17));
        this.getChildren().add(getCircle(c21));
        this.getChildren().add(getCircle(c22));
        this.getChildren().add(getCircle(c23));
        this.getChildren().add(getCircle(c24));
        this.getChildren().add(getCircle(c25));
        this.getChildren().add(getCircle(c26));
        this.getChildren().add(getCircle(c27));
        this.getChildren().add(getCircle(c31));
        this.getChildren().add(getCircle(c32));
        this.getChildren().add(getCircle(c33));
        this.getChildren().add(getCircle(c34));
        this.getChildren().add(getCircle(c35));
        this.getChildren().add(getCircle(c36));
        this.getChildren().add(getCircle(c37));
        this.getChildren().add(getCircle(c41));
        this.getChildren().add(getCircle(c42));
        this.getChildren().add(getCircle(c43));
        this.getChildren().add(getCircle(c44));
        this.getChildren().add(getCircle(c45));
        this.getChildren().add(getCircle(c46));
        this.getChildren().add(getCircle(c47));
        this.getChildren().add(getCircle(c51));
        this.getChildren().add(getCircle(c52));
        this.getChildren().add(getCircle(c53));
        this.getChildren().add(getCircle(c54));
        this.getChildren().add(getCircle(c55));
        this.getChildren().add(getCircle(c56));
        this.getChildren().add(getCircle(c57));
        this.getChildren().add(getCircle(c61));
        this.getChildren().add(getCircle(c62));
        this.getChildren().add(getCircle(c63));
        this.getChildren().add(getCircle(c64));
        this.getChildren().add(getCircle(c65));
        this.getChildren().add(getCircle(c66));
        this.getChildren().add(getCircle(c67));
    }

    public Circle getCircle(Circle cxx) {
        return cxx;
    }

    public void setCircleFill(Circle cxx, double red, double green, double blue) {
        cxx.setFill(Color.color(red,green,blue));
    }

    public void setCircleFill(Circle cxx, String hex) {
        cxx.setFill(Color.web(hex));
    }
}//Board Class
