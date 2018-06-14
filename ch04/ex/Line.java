package ch04.ex;

import ch04.ex.Point;

public class Line extends Shape implements Cloneable {
    private Point end;
    public Line(Point from, Point to) {
        super(from);
        this.end = to;
    }

    public Point getCenter() {
        return new Point((p.x + end.x) / 2,
                         (p.y + end.y) / 2);
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
        sb.append("from=");
        sb.append(p);
        sb.append(variableSeparator);
        sb.append("to=");
        sb.append(end);
        sb.append("]");

        return sb.toString();
    }

    public Line clone() throws CloneNotSupportedException {
        Shape s = (Shape)super.clone();
        return new Line(s.p, end);
    }

    public static void main(String[] args) {
        Point from = new Point(1, 1);
        Point to = new Point(3, 3);
        Line l = new Line(from, to);
        System.out.println(l.getCenter());
        try {
            System.out.println(l.clone());
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex);
        }
    }

}
