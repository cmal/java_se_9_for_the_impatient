package ch04.ex;

public class DiscountedItem extends Item {
    private double discount;

    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        DiscountedItem other = (DiscountedItem) otherObject;
        return discount == other.discount;
    }

}
