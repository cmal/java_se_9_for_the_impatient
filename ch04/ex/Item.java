package ch04.ex;

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
        if (getClass() != other.getClass()) return false;
        Item p = (Item) other;
        return Objects.equals(description, other.description)
            && price == other.price;
    }
}
