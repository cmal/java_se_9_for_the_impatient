package ch04.ex;

import ch04.ex.Point;

public class Rectangle extends Shape {
    private double height;
    private double width;

    Rectangle(Point topLeft, double height, double width) {
        super(topLeft);
        this.height = height;
        this.width = width;
    }

    public Point getCenter() {
        return new Point(this.p.x + height / 2,
                         this.p.y + width / 2);
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
        sb.append("topLeft=");
        sb.append(p);
        sb.append(variableSeparator);
        sb.append("height=");
        sb.append(height);
        sb.append(variableSeparator);
        sb.append("width=");
        sb.append(width);
        sb.append("]");

        return sb.toString();
    }

    public Rectangle clone() throws CloneNotSupportedException {
        Shape s = (Shape)super.clone();
        return new Rectangle(s.p, height, width);
    }

    public static void main(String[] args) {
        Point topLeft = new Point(1, 1);
        Rectangle l = new Rectangle(topLeft, 3, 5);
        System.out.println(l.getCenter());
        try {
            System.out.println(l.clone());
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex);
        }
    }

}
