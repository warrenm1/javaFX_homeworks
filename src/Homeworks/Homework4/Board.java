package Homeworks.Homework4;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Board extends Pane {
    private Rectangle rectangle = new Rectangle(400,360,Color.web("#0f2439"));

    private Rectangle column1 = new Rectangle(30,30,40,290);
    private Rectangle column2 = new Rectangle(80,30,40,290);
    private Rectangle column3 = new Rectangle(130,30,40,290);
    private Rectangle column4 = new Rectangle(180,30,40,290);
    private Rectangle column5 = new Rectangle(230,30,40,290);
    private Rectangle column6 = new Rectangle(280,30,40,290);
    private Rectangle column7 = new Rectangle(330,30,40,290);
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

    public ArrayList<Circle> col1Circles(){
        ArrayList<Circle> col1 = new ArrayList();
        col1.add(0,c11);
        col1.add(1,c21);
        col1.add(2,c31);
        col1.add(3,c41);
        col1.add(4,c51);
        col1.add(5,c61);
        return col1;
    }

    public ArrayList<Circle> col2Circles(){
        ArrayList<Circle> col2 = new ArrayList();
        col2.add(0,c12);
        col2.add(1,c22);
        col2.add(2,c32);
        col2.add(3,c42);
        col2.add(4,c52);
        col2.add(5,c62);
        return col2;
    }

    public ArrayList<Circle> col3Circles(){
        ArrayList<Circle> col3 = new ArrayList();
        col3.add(0,c13);
        col3.add(1,c23);
        col3.add(2,c33);
        col3.add(3,c43);
        col3.add(4,c53);
        col3.add(5,c63);
        return col3;
    }

    public ArrayList<Circle> col4Circles(){
        ArrayList<Circle> col4 = new ArrayList();
        col4.add(0,c14);
        col4.add(1,c24);
        col4.add(2,c34);
        col4.add(3,c44);
        col4.add(4,c54);
        col4.add(5,c64);
        return col4;
    }

    public ArrayList<Circle> col5Circles(){
        ArrayList<Circle> col5 = new ArrayList();
        col5.add(0,c15);
        col5.add(1,c25);
        col5.add(2,c35);
        col5.add(3,c45);
        col5.add(4,c55);
        col5.add(5,c65);
        return col5;
    }

    public ArrayList<Circle> col6Circles(){
        ArrayList<Circle> col6 = new ArrayList();
        col6.add(0,c16);
        col6.add(1,c26);
        col6.add(2,c36);
        col6.add(3,c46);
        col6.add(4,c56);
        col6.add(5,c66);
        return col6;
    }

    public ArrayList<Circle> col7Circles(){
        ArrayList<Circle> col7 = new ArrayList();
        col7.add(0,c17);
        col7.add(1,c27);
        col7.add(2,c37);
        col7.add(3,c47);
        col7.add(4,c57);
        col7.add(5,c67);
        return col7;
    }

    public Board() {
        this.getChildren().add(getRectangle(rectangle));

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

        this.getChildren().add(getColumn1());
        this.getChildren().add(getColumn2());
        this.getChildren().add(getColumn3());
        this.getChildren().add(getColumn4());
        this.getChildren().add(getColumn5());
        this.getChildren().add(getColumn6());
        this.getChildren().add(getColumn7());
    }//Board Constructor

    public Rectangle getRectangle(Rectangle rectangle){
        return rectangle;
    }//getRectangle

    public Rectangle getColumn1(){ column1.setFill(Color.TRANSPARENT); return column1; }
    public Rectangle getColumn2(){ column2.setFill(Color.TRANSPARENT); return column2; }
    public Rectangle getColumn3(){ column3.setFill(Color.TRANSPARENT); return column3; }
    public Rectangle getColumn4(){ column4.setFill(Color.TRANSPARENT); return column4; }
    public Rectangle getColumn5(){ column5.setFill(Color.TRANSPARENT); return column5; }
    public Rectangle getColumn6(){ column6.setFill(Color.TRANSPARENT); return column6; }
    public Rectangle getColumn7(){ column7.setFill(Color.TRANSPARENT); return column7; }



    public Circle getCircle(Circle cxx) {
        return cxx;
    }//getCircle

    public void setCircleFill(Circle cxx, double red, double green, double blue) {
        cxx.setFill(Color.color(red,green,blue));
    }//setCircleFill rgb

    public void setCircleFill(Circle cxx, String hex) {
        cxx.setFill(Color.web(hex));
    }//setCircleFill hex
}//Board Class
