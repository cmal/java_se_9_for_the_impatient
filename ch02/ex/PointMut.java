package ch02.ex;

/**
 * Mutable Point
 *
 * @author Yu Zhao
 */
public class PointMut {
    private double x, y;

    PointMut () {
        this.x = 0;
        this.y = 0;
    }

    /**
     * @param x X coordinate of point
     * @param y Y coordinate of point
     */
    PointMut (double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return X coordinate of point.
     */
    public double getX() {
        return x;
    }

    /**
     * @return Y coordinate of point.
     */
    public double getY() {
        return y;
    }
    
    /**
     * @param x X coordinate of point.
     * @param y Y coordinate of point.
     */
    public PointMut translate(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * @param scale scale to multiply to X and Y coordinate of point.
     */
    public PointMut scale(double scale) {
        this.x = scale * x;
        this.y = scale * y;
        return this;
    }

    /**
     * @return the string representation of point.
     */
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
