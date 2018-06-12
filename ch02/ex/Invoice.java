package ch02.ex;

import java.util.ArrayList;

public class Invoice {
    private static class Item {
        // Item is nested inside Invoice
        private String description;
        private int quantity;
        private double unitPrice;

        Item () {
        }

        public Item(String description, int quantity, double unitPrice) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }
        
        double price() {
            return quantity * unitPrice;
        }
        
    }

    private ArrayList<Item> items;

    Invoice() {
         items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }
    
    public void addItem(String description, int quantity, double unitPrice) {
        Item newItem = new Item();
        newItem.description = description;
        newItem.quantity = quantity;
        newItem.unitPrice = unitPrice;
        items.add(newItem);
    }

    public void print() {
        for (Item item : items) {
            System.out.printf("Desc: %s\n", item.description);
            System.out.printf("Quantity: %d\n", item.quantity);
            System.out.printf("Price: %f\n", item.unitPrice);
        }
    }

    public static void main(String[] args) {
        Invoice myInvoice = new Invoice();
        Invoice.Item newItem = new Invoice.Item("Blackwell Toaster", 2, 19.95);
        myInvoice.add(newItem);
        // myInvoice.add(newItem);
        myInvoice.print();
    }

}
