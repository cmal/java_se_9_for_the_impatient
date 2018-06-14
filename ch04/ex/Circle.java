package ch04.ex;

import ch04.ex.Shape;

public class Circle extends Shape implements Cloneable {
    private double radius;

    Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    public Point getCenter() {
        return this.p;
    }

    public double getRadius() {
        return this.radius;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        final int sbSize = 1000;
        final String variableSeparator = ",";
        final StringBuffer sb = new StringBuffer(sbSize);

        sb.append(getClass().getName());
        sb.append("[");
        sb.append("center=").append(getCenter());
        sb.append(variableSeparator);
        sb.append("radius=").append(radius);
        sb.append("]");

        return sb.toString();
    }

    public Circle clone() throws CloneNotSupportedException {
        Shape s = (Shape)super.clone();
        return new Circle(s.p, radius);
    }

    public static void main(String[] args) {
        Point p = new Point(1, 1);
        Circle c = new Circle(p, 3);
        System.out.println(c.getCenter());
        try {
            System.out.println(c.clone());
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex);
        }
    }
}
