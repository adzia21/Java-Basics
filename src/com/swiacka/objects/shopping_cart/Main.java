package com.company.objects.shopping_cart;

import org.junit.jupiter.api.Assertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Store store = new Store();
    static Cart cart = new Cart();

    public static void main(String[] args) throws FileNotFoundException {

        loadItems("products.txt");

        manageItems();

    }

    public static void loadItems(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            Scanner scanner = new Scanner(fis);
            for (int i = 0; scanner.hasNextLine(); i++) {
                String line = scanner.nextLine();
                String[] splitted = line.split(";");
                for (int j = 0; j < splitted.length; j++) {
                    String[] splittedToField = splitted[j].split("=");
                    store.setItem(i, j, new Item(splittedToField[0], Double.parseDouble(splittedToField[1])));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    public static void manageItems() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\n\t******************************JAVA GROCERS******************************\n");

                System.out.println(store);

                System.out.println("Options:\n\ta) add to cart\n\tb) remove from cart\n\tc)checkout\n\titem.");

                String userChoice = scanner.nextLine();

                if (userChoice.equals("a")) {
                    System.out.print("\nChoose an aisle number between: 1 – 7: ");
                    int userAisleNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Choose an item number between: 1 – 3: ");
                    int userItemNumber = scanner.nextInt();
                    scanner.nextLine();

                    Item item = store.getItem(userAisleNumber, userItemNumber);
                    if (cart.add(item)) {
                        System.out.println(item.getName() + " was added to your shopping cart.");
                    } else {
                        System.out.println(item.getName() + " is already in your shopping cart.");
                    }

                }
                if (userChoice.equals("b")) {
                    try{
                        System.out.print("Enter the item you'd like to remove: ");
                        String itemToRemove = scanner.nextLine();
                        cart.remove(itemToRemove);}
                    catch (IllegalStateException e){
                        System.out.println("Cart is empty.");
                        continue;
                    }



                }
                if (userChoice.equals("c")) {
                    try{System.out.println(cart.checkOut());}catch (IllegalStateException e){
                        System.out.println("Cart is empty.");
                    }

                }

                System.out.println("\n\nSHOPPING CART\n\n" + cart);


            } catch (InputMismatchException e) {
                System.out.println(" Wrong input. Enter a number.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Incorrect value. Please type a number in range.");
            }
        }
    }

}
