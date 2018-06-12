package ch02.ex;

/**
 * Immutable Point
 *
 * @author Yu Zhao
 */
public class Point {
    private final double x, y;

    Point () {
        this.x = 0;
        this.y = 0;
    }

    /**
     * @param x X coordinate of point
     * @param y Y coordinate of point
     */
    Point (double x, double y) {
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
    public Point translate(double x, double y) {
        return new Point(x, y);
    }

    /**
     * @param scale scale to multiply to X and Y coordinate of point.
     */
    public Point scale(double scale) {
        return new Point(scale * x, scale * y);
    }

    /**
     * @return the string representation of point.
     */
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
