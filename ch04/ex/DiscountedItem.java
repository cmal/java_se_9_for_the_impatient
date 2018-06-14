package ch04.ex;

import ch04.ex.Item;

public class DiscountedItem extends Item {
    private double discount;

    DiscountedItem(String argDescription, double argPrice, double argDiscount) {
        super(argDescription, argPrice);
        this.discount = argDiscount;
    }

    // implement a problematic equals method
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Item) {
            return super.equals(otherObject);
        }
        DiscountedItem other = (DiscountedItem) otherObject;
        return discount == other.discount && super.equals(otherObject);
    }

    public static void main(String[] args) {
        DiscountedItem i1 = new DiscountedItem("Item", 3.5, 0.7);
        Item           i2 = new           Item("Item", 3.5     );
        DiscountedItem i3 = new DiscountedItem("Item", 3.5, 0.8);
        System.out.printf("i1 = i2: %b\n", i1.equals(i2)); // true
        System.out.printf("i2 = i3: %b\n", i2.equals(i3)); // true
        System.out.printf("i1 = i3: %b\n", i1.equals(i3)); // true, this is WRONG!
    }

}
