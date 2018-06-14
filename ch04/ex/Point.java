package ch04.ex;

import java.util.Objects;

public class Point {
    private double x;
    private double y;

    Point(double argX, double argY) {
        x = argX;
        y = argY;
    }
    
    /**
     * Gets the value of x
     *
     * @return the value of x
     */
    public final double getX() {
        return this.x;
    }

    /**
     * Gets the value of y
     *
     * @return the value of y
     */
    public final double getY() {
        return this.y;
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
        sb.append("x=").append(x);
        sb.append(variableSeparator);
        sb.append("y=").append(y);
        sb.append("]");

        return sb.toString();
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        Point p = (Point) other;
        return this.getX() == p.getX() &&
            this.getY() == p.getY();
    }

    public int hashCode() {
        return Objects.hash(this.getX(), this.getY());
    }
}
