package com.company.objects.shopping_cart;

public class Item {

    private String name;
    private double price;

    public Item(String name, double price) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (price < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
    }

    public Item(Item item) {
        this.name = item.getName();
        this.price = item.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Item)) {
            return false;
        }

        Item item = (Item) obj;

        return this.name.equals(item.name) && this.price == item.price;
    }

    @Override
    public String toString() {
        return name + ": $" + price + " ";
    }
}
