package ch02.ex;

import java.lang.Integer;

public class Point {
    private final double x, y;

    public Point () {
        this.x = 0;
        this.y = 0;
    }

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public Point translate(double x, double y) {
        return new Point(x, y);
    }

    public Point scale(double scale) {
        return new Point(scale * x, scale * y);
    }

    public String toString() {
        return new String("Point: x=" + x + ", y=" + y);
    }

    public static void main(String[] args) {

        System.out.println(new Point());
        System.out.println(new Point(3, 2));
        Point pt = new Point(0, 0);
        System.out.println(pt);
        System.out.println(pt.translate(1, 1));
        System.out.println(pt.translate(2, 2).scale(3.5));
    }
}
