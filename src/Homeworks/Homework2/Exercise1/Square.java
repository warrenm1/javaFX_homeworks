package Homeworks.Homework2.Exercise1;

public class Square extends Shape {
    private int side;

    public Square(){ side = 1; }

    public Square(int s){ side = s; }

    public int getSide(){ return this.side; }

    public void setSide(int n){ side = n; return;}

    public double getArea(){ return getSide() * getSide(); }
}
