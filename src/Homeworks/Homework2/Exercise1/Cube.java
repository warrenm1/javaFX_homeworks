package Homeworks.Homework2.Exercise1;

public class Cube extends Shape {
    private int side;

    public Cube(){
        side = 1;
    }

    public Cube(int s){
        side = s;
    }

    public int getSide(){ return side; }

    public void setSide(int s){ side = s; return; }

    public double getArea(){ return 6 * side * side * side; }
}
