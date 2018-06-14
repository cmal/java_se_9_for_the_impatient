package ch04.ex;

import ch04.ex.Point;

public abstract class Shape implements Cloneable {
    protected Point p;

    Shape(Point p) {
        this.p = p;
    }

    public void moveBy(double dx, double dy) {
        p.setX(p.getX() + dx);
        p.setY(p.getY() + dy);
    }

    public abstract Point getCenter();

    /**
     * {@inheritDoc}
     */
    public abstract String toString();


}
