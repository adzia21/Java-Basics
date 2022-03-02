package com.swiacka.basics;

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        /**
         *
         * studentsPlace();
         * javaGrocer();
         * pacmanScore();
         * appleShop();
         * pizzaDelivery();
         */

        arrays2d();

    }


    public static void pizzaDelivery() {
        System.out.println("How many pizza toppings do u want?");
        Scanner scanner = new Scanner(System.in);
        String toppingsNumber = scanner.nextLine();

        int toppingsNumberToInt = Integer.parseInt(toppingsNumber);

        String[] toppings = new String[toppingsNumberToInt];

        System.out.println("Great, enter each topping! ");

        for (int i = 0; i < toppings.length; i++) {
            System.out.print(i + ". ");
            String userToppings = scanner.nextLine();
            toppings[i] = userToppings;
        }

        System.out.println("Thank you! Here are the toppings your ordered: ");
        for (int i = 0; i < toppings.length; i++) {
            System.out.println(i + ". " + toppings[i]);
        }

        System.out.println("Press enter to confirm your order!");
        scanner.nextLine();
        System.out.println("Great! A driver is on the way!");
    }

    public static void appleShop() {
        System.out.println("Here is your receipt: ");

        String[] apples = {"Gala", "Granny Smith", "Macintosh"};
        double[] price = {1.99, 1.49, 1.29};

        for (int i = 0; i < apples.length; i++) {
            System.out.println(apples[i] + ": $" + price[i]);
        }
    }

    public static void pacmanScore() {
        int[] score = new int[10];
        int highScore = 0;
        System.out.print("Here are the scores: ");
        int seat = 0;

        for (int i = 0; i < score.length; i++) {
            score[i] = randomNumber();
            System.out.print(score[i] + ",    ");
            if (score[i] > highScore) {
                highScore = score[i];
                seat = i;

            }
        }
        System.out.println("\nNew high score is: " + highScore);
        System.out.println("It's the gentleman in seat: " + seat + ". Give him cookies!");
    }

    public static int randomNumber() {
        double randomNumber = Math.random() * 50000;
        randomNumber += 1;
        return (int) randomNumber;
    }

    public static void javaGrocer() {
        System.out.println("Do you sell coffee?");
        String[] aisles = {"apples", "bananas", "candy", "chocolate", "coffee", "tea"};

        for (int i = 0; i < aisles.length; i++) {
            if (aisles[i].equals("coffee")) {

                System.out.println("We have that in aisle: " + i);
            }
        }
    }

    public static void studentsPlace() {
        String[] students = {"Malfoy", "Crabbe", "Pansy", "Dean"};

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + ", you will take seat " + i);
        }
    }

    public static void arrays2d() {
        String[][] testArray =
                {
                        {"Ala", "Zuzia"},
                        {"Ania", "Ma", "kota"}
                };
        for (int i = 0; i < testArray.length; i++){
            for (int j = 0; j < testArray[i].length; j++){
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                System.out.print(testArray[i][j] + " ");
            }
            System.out.println(" \n" );
        }
    }
}
