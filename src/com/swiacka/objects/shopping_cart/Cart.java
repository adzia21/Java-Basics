package com.company.objects.shopping_cart;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Item getItem(int index) {
        return new Item(items.get(index));
    }

    public void setItem(int index, Item item) {
        items.add(index, new Item(item));
    }

    public boolean add(Item item) {
        if (items.contains(item)) {
            return false;
        }
        items.add(item);
        return true;
    }

    public void remove(String name) {
        if(items.isEmpty()){
            throw new IllegalStateException();
        }

        items.removeIf(item -> item.getName().equals(name));
    }

    public double getSubtotal(){
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public double getTax(){
        DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        return Double.parseDouble(formatter.format(getSubtotal()*0.13));
    }

    public double getTotal(){
        return getSubtotal() + getTax();
    }
    public String checkOut() {
        if(items.isEmpty()){
            throw new IllegalStateException();
        }
        getTotal();
        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + getSubtotal() + "\n" +
                "\tTax: $" + getTax() + "\n" +
                "\tTotal: $" + getTotal() + "\n";
    }


    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp += items.get(i).toString();
        }
        return temp;
    }


}
