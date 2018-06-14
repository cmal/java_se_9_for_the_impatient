package ch04.ex;

import ch04.ex.Point;
import java.util.Objects;

public class LabeledPoint extends Point implements Cloneable {

    private String label;

    LabeledPoint(String argLabel, double argX, double argY) {
        super(argX, argY);
        label = argLabel;
    }

    /**
     * Gets the value of label
     *
     * @return the value of label
     */
    public final String getLabel() {
        return label;
    }

    public final void setLabel(String argLabel) {
        this.label = argLabel;
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
        sb.append("label=").append(label);
        sb.append(variableSeparator);
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
        LabeledPoint lp = (LabeledPoint) other;
        return label == lp.getLabel() &&
            x == lp.getX() &&
            y == lp.getY();
    }

    public int hashCode() {
        return Objects.hash(x, y, label);
    }

    public LabeledPoint clone() throws CloneNotSupportedException {
        return new LabeledPoint(this.getLabel(), this.getX(), this.getY());
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

        // protected field can be accessed in subclass instances.
        System.out.println(lp.x);
        try {
            System.out.println(lp.clone());
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex);
        }
    }

}
