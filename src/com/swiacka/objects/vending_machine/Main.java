package com.company.objects.vending_machine;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\t\t *****************************************");
        System.out.println("\t\t\t\t WELCOME TO JAVA DRINKS");
        System.out.println("\t\t *****************************************");

        //Item[][] items = new Item[][]{{new Item("Pepsi", 1.99, 3), new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2)}, {new Item("Fanta", 1.99, 2), new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3)}, {new Item("Crush", 1.99, 2), new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1)}};
        Item[][] items = new Item[][]{
                {new Item("Pepsi", 1.99, 3), new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2)},
                {new Item("Fanta", 1.99, 2), new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3)},
                {new Item("Crush", 1.99, 2), new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1)}
        };
        VendingMachine vendingMachine = new VendingMachine(items);

        vendingMachine.dispense(2, 2);
        vendingMachine.dispense(2, 2);
        vendingMachine.dispense(2, 2);
        vendingMachine.dispense(2, 2);
        vendingMachine.dispense(2, 2);


        while (true) {
            System.out.println(vendingMachine);


            System.out.println("Pick a row: ");
            int row = scanner.hasNextInt() ? scanner.nextInt() : 404;
            scanner.nextLine();

            System.out.println("Pick a spot in the row: ");
            int spot = scanner.hasNextInt() ? scanner.nextInt() : 404;
            scanner.nextLine();

            if (row > vendingMachine.getLength() || row < 0) {
                System.out.println("Invalid range");
                continue;
            }

            if (spot > vendingMachine.getRowLength(row) || spot < 0) {
                System.out.println("Invalid range");
                continue;
            }


            if (row == 404 || spot == 404) {
                System.out.println("invalid value");
                continue;
            }
            boolean doesUserChoiceIsGood = vendingMachine.dispense(row, spot);

            if (!doesUserChoiceIsGood) {
                System.out.println("\nSorry, we're out of this item. Press 1 to purchase another: ");
            }
            if (doesUserChoiceIsGood) {
                System.out.println("Enjoy your drink! Press 1 to purchase another: ");
            }
            int userChoice = scanner.nextInt();
            if (userChoice != 1) {
                break;
            }
        }
    }

}

