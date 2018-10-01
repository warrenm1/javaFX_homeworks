package Homeworks.Homework2.Exercise1;

import java.util.*;

public class TestShape {
    public static void main(String args[]){
        ArrayList shapes = new ArrayList();

        Shape square = new Square();
        Shape cube = new Cube();
        Shape triangle = new Triangle();
        Shape pyramid = new Pyramid();

        Shape sq = new Square(15);
        Shape c = new Cube(14);
        Shape tri = new Triangle(7);
        Shape pyr = new Pyramid(24);


        shapes.add(square);
        shapes.add(sq);
        shapes.add(cube);
        shapes.add(c);
        shapes.add(triangle);
        shapes.add(tri);
        shapes.add(pyramid);
        shapes.add(pyr);

        for (int i = 0; i < shapes.size(); i++){
            System.out.println("***********************************");
            System.out.println("Class: " + shapes.get(i));
            System.out.println("Side: " + shapes.get(i).getArea());
        }
    }
}
