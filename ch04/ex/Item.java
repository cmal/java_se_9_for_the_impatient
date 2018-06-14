package ch04.ex;

import java.util.Objects;

public class Item {
    private String description;
    private double price;

    Item(String argDescription, double argPrice) {
        description = argDescription;
        price = argPrice;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        // if comment this:
        // if (getClass() != other.getClass()) return false;
        // and use this:
        if (!(other instanceof Item)) return false;
        Item p = (Item) other;
        return Objects.equals(description, p.description)
            && price == p.price;
    }
}
