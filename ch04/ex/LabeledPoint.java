package ch04.ex;

import ch04.ex.Point;
import java.util.Objects;

public class LabeledPoint extends Point {

    private String label;
    
    LabeledPoint(String argLabel, double argX, double argY) {
        super(argX, argY);
        this.label = argLabel;
    }

    /**
     * Gets the value of label
     *
     * @return the value of label
     */
    public final String getLabel() {
        return this.label;
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
        sb.append("label=").append(this.getLabel());
        sb.append(variableSeparator);
        sb.append("x=").append(this.getX());
        sb.append(variableSeparator);
        sb.append("y=").append(this.getY());
        sb.append("]");

        return sb.toString();
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        LabeledPoint lp = (LabeledPoint) other;
        return getLabel() == lp.getLabel() &&
            this.getX() == lp.getX() &&
            this.getY() == lp.getY();
    }

    public int hashCode() {
        return Objects.hash(this.getX(), this.getY(), this.getLabel());
    }
    
    public static void main(String[] args) {
        LabeledPoint lp = new LabeledPoint("label_1", 344, 24.5);
        Point p = new Point(277, 48.3);
        System.out.println(lp.getX());
        System.out.println(lp.getY());
        System.out.println(lp.getLabel());
        System.out.println(p);
        System.out.println(lp);
        System.out.println(p.equals(lp));
        System.out.println(lp.equals(p));
        LabeledPoint lp2 = new LabeledPoint("label_1", 344, 24.5);
        System.out.println(lp.equals(lp2));
        System.out.printf("hashCodes: %d %d %d\n",
                          p.hashCode(),
                          lp.hashCode(),
                          lp2.hashCode());
    }

}
