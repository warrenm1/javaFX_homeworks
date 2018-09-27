package Homeworks.Homework2.Exercise1;

import java.lang.Math;

public class Pyramid extends Shape {
    private int side;
    private double height;

    public Pyramid(){
        side = 1;
        height = Math.sqrt(3) / 2;
    }

    public Pyramid(int s){
        side = s;
        height = s * Math.sqrt(3) / 2;
    }

    public int getSide(){ return side; }
    public double getHeight(){ return height; }

    public void setSide(int s){
        side = s;
        height = s * Math.sqrt(3) / 2;
        return;
    }

    public double getArea(){
        return 2 * side * height;
    }
}
