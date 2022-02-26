package com.swiacka.basics;

import java.util.Scanner;

public class RollingJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's play Rolling Java. Type anything to start.\n");

        System.out.println("Great, here are the rules:");
        System.out.println(">> - If you roll a 6 the game stops.\n" +
                ">> - If you roll a 4 nothing happens.\n" +
                ">> - Otherwise, you get 1 point\\n.\n" +
                ">>You must collect at least 3 points to win. Enter anything to roll:");


        int points = 0;
        while (true) {

            String roll = scanner.nextLine();
            int rolledNumber = rollDice();
            System.out.println("You rolled a " + rolledNumber + ".");


            if (rolledNumber == 3 || rolledNumber == 5 || rolledNumber == 2 || rolledNumber == 1) {
                System.out.println("One point. Keep rolling.");
                points++;
                System.out.println("Points: " + points);
            } else if (rolledNumber == 4) {
                System.out.println("Zero points. Keep rolling.");
                System.out.println("Points: " + points);
            } else if (rolledNumber == 6) {
                System.out.println("Points: " + points);
                System.out.println("Tough luck, you lose :(");
                break;
            }


            if (points >= 3) {
                System.out.println("Wow, that's lucky. You win!");
            }
        }


    }

    public static int rollDice() {
        double randomNumber = Math.random() * 6;
        randomNumber += 1;
        return (int) randomNumber;
    }


}
