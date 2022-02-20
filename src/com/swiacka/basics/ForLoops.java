package com.swiacka.basics;

import java.util.Scanner;

/**
 * Here are some exercises with loops.
 * Remove the comment from the method to see how it works.
 */


public class ForLoops {
    public static void main(String[] args) {
        /**
         * FOR LOOPS:
         *
         * printTenTimes();
         * printCustomText();
         * countingWithTimmy();
         * sing();
         * counterTool();
         * evenOrOdd();
         */
    }

    public static void printTenTimes() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ". If Java was easy, they would call it Python!");
        }
    }

    public static void printCustomText() {
        System.out.println("Hello, I can write your text 99 times! Just text what u want: ");
        Scanner scanner = new Scanner(System.in);
        String userText = scanner.nextLine();
        for (int i = 1; i <= 99; i++) {
            System.out.println(i + ". " + userText);
        }
    }

    public static void countingWithTimmy() {
        System.out.println("Hi Timmy! Choose a number to count to: ");
        Scanner scanner = new Scanner(System.in);
        int numberToCount = scanner.nextInt();

        for (int i = 0; i <= numberToCount; i++) {
            System.out.print(i + " ");
        }
    }

    public static void sing() {
        for (int i = 99; i >= 1; i--) {
            System.out.println(i + " bottles of beer on the wall, " + i + " bottles of beer!\n" + " take one down, pass it around " + (i - 1) + ",bottles of beer on the wall!");
        }
    }

    public static void counterTool() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a number to count by: ");
        int countBy = scanner.nextInt();
        System.out.println("Pick a number to start counting from:");
        int countFrom = scanner.nextInt();
        System.out.println("Pick a number to count to: ");
        int countTo = scanner.nextInt();

        for (int i = countFrom; i <= countTo; i += countBy) {
            System.out.print(i + " ");
        }
    }

    public static void evenOrOdd() {
        for (int i = 0; i <= 19; i++) {
            String evenOrOddNumber;
            if (i % 2 == 0) {
                evenOrOddNumber = "even";
            } else {
                evenOrOddNumber = "odd";
            }
            System.out.println(i + " - " + evenOrOddNumber);
        }
    }

}
