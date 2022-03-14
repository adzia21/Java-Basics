package com.company.objects.vending_machine;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        if(name == null){
            throw new IllegalArgumentException("name cannot be null/blank.");
        }
        if (price < 0){
            throw new IllegalArgumentException("price cannot be less than 0");
        }
        if(quantity < 0){
            throw new IllegalArgumentException("quantity cannot be less than 0");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name) {
        if(name == null || name.equals("")){
            throw new IllegalArgumentException("name is blank or null");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("price is less than 0");
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0){
            throw new IllegalArgumentException("quantity is less than 0");
        }
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + price + " (" + quantity + ')';
    }
}
