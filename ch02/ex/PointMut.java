package ch02.ex;

import java.lang.Integer;

public class PointMut {
    private double x, y;

    PointMut () {
        this.x = 0;
        this.y = 0;
    }

    PointMut (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public PointMut translate(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public PointMut scale(double scale) {
        this.x = scale * x;
        this.y = scale * y;
        return this;
    }

    public String toString() {
        return new String("PointMut: x=" + x + ", y=" + y);
    }

    public static void main(String[] args) {

        System.out.println(new PointMut());
        System.out.println(new PointMut(3, 2));
        PointMut pt = new PointMut(0, 0);
        System.out.println(pt);
        System.out.println(pt.translate(1, 1));
        System.out.println(pt.translate(2, 2).scale(3.5));
    }
}
