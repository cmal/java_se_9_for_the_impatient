package ch04.ex;

import java.util.Objects;

public class Point implements Cloneable {
    protected double x;
    protected double y;

    public Point(double argX, double argY) {
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
     * Sets the value of x
     *
     * @param argX Value to assign to this.x
     */
    public final void setX(final double argX) {
        this.x = argX;
    }

    /**
     * Sets the value of y
     *
     * @param argY Value to assign to this.y
     */
    public final void setY(final double argY) {
        this.y = argY;
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

    public Point clone() throws CloneNotSupportedException {
        return new Point(x, y);
    }
}
