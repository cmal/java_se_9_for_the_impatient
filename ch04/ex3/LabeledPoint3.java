package ch04.ex3;

import ch04.ex.LabeledPoint;

public class LabeledPoint3 extends LabeledPoint {
    private double z;

    LabeledPoint3(String argLabel, double argX, double argY, double argZ) {
        label = argLabel;
        x = argX;
        y = argY;
        z = argZ;
    }

    public void printProtecedX() {
        System.out.println(this.x);
    }

    public static void main(String[] args) {
        LabeledPoint3 p3 = new LabeledPoint3("label_3", 255, 3.5, 17);
        p3.printProtecedX();
    }
}
