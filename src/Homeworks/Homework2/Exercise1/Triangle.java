package Homeworks.Homework2.Exercise1;

import java.lang.Math;

public class Triangle extends Shape{
    private int side;
    private double height;

    public Triangle(){
        side = 1;
        height = Math.sqrt(3)/2;
    }

    public Triangle(int s){
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

    public double getArea(){ return (1/2) * side * height; }
}
