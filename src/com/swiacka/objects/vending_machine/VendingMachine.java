package com.company.objects.vending_machine;

import java.util.Arrays;
import java.util.Scanner;

public class VendingMachine {

    private Item[][] items = new Item[3][3];

    public VendingMachine(Item[][] items) {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                this.items[i][j] = new Item(items[i][j].getName(), items[i][j].getPrice(), items[i][j].getQuantity());
            }
        }
    }


    public Item getItem(int row, int spot) {
        return new Item(items[row][spot].getName(), items[row][spot].getPrice(), items[row][spot].getQuantity());
    }

    public void setItem(Item item, int row, int spot) {
        this.items[row][spot] = new Item(item.getName(), item.getPrice(), item.getQuantity());
    }

    public boolean dispense(int row, int spot) {
        int quantity = this.items[row][spot].getQuantity();
        if(quantity < 0) {
            throw new IllegalArgumentException("quantity is less than 0");
        }
        if (quantity > 0) {
            this.items[row][spot].setQuantity(quantity - 1);
            return true;
        } else {
            return false;
        }
    }

    public int getLength(){
        return items.length;
    }

    public int getRowLength(int userLength){
        return items[userLength].length;
    }
    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.length ; i++) {
            for (int j = 0; j < this.items[i].length; j++) {
               temp += this.items[i][j].getName() + ": " + this.items[i][j].getPrice() + " (" + this.items[i][j].getQuantity() + ") \t";
            }
            temp += "\n";
        }
        temp += "\t\t *****************************************";
        return temp;
    }
}
