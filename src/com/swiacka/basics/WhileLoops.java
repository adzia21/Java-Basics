package com.swiacka.basics;

import java.util.Scanner;

/**
 * Here are some exercises with loops.
 * Remove the comment from the method to see how it works.
 */

public class WhileLoops {

    public static void main(String[] args) {
        /**
         * WHILE LOOPS:
         * secretNumber();
         * rollDices();
         * login();
         */

    }

    public static void secretNumber() {
        double secretNumber = Math.random() * 5;
        secretNumber += 1;
        secretNumber = (int) secretNumber;

        System.out.print("I chose a number between 1 and 5. Try to guess it: ");

        Scanner scanner = new Scanner(System.in);
        int userNumber = scanner.nextInt();

        while (userNumber != secretNumber) {
            System.out.print("Guess again: ");
            userNumber = scanner.nextInt();
        }

        System.out.println("You got it!");
    }



    public static void login() {
        System.out.println("Welcome. Please, sign in below :)");

        String username = "Samantha";
        String password = "Java<3";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String userUsername = scanner.nextLine();

        System.out.print("Password: ");
        String userPassword = scanner.nextLine();

        while (!userUsername.equals("Samantha") && !userPassword.equals("Java<3")) {
            System.out.println("Incorrect, please try again!");

            System.out.print("Username: ");
            userUsername = scanner.nextLine();

            System.out.print("Password: ");
            userPassword = scanner.nextLine();
        }

        System.out.println("Sign in successful. Welcome!");

    }

    public static int rollDice() {
        double randomNumber = Math.random() * 6;
        randomNumber += 1;
        return (int) randomNumber;
    }

    public static void rollDices() {
        int dice1 = 0;
        int dice2 = 1;
        while (dice1 != dice2) {
            dice1 = rollDice();
            dice2 = rollDice();
            System.out.println("Dice 1: " + dice1 + "\nDice 2: " + dice2 + "\n\n");
        }

        System.out.println("Here you have same numbers: Dice 1: " + dice1 + "\nDice 2: " + dice2 + "\n\n");
    }

}
