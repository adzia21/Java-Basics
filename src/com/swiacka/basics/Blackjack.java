package com.swiacka.basics;

import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Welcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall se...");
        System.out.println("Ready? Press anything to begin!");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("Get two random cards by pressing enter!");
        scanner.nextLine();

        int userCard1 = randomNumber();
        int userCard2 = randomNumber();

        System.out.println("You get a: \n");
        System.out.println(drawRandomCard(userCard1));

        scanner.nextLine();

        System.out.println("and a : \n");
        System.out.println(drawRandomCard(userCard2));

        if (userCard1 >= 11) {
            userCard1 = 10;
        }
        if (userCard2 >= 11) {
            userCard2 = 10;
        }


        System.out.println("Your total value is: " + (userCard1 + userCard2) + " . \n Press enter to see dealers cards.");
        scanner.nextLine();

        int dealerCard1 = randomNumber();
        int dealerCard2 = randomNumber();

        System.out.println("Dealer got: \n" + drawRandomCard(dealerCard1) + " and has a card facing down\n" + faceDown());
        System.out.println("The dealer's total is hidden.");


        int dealerScore = dealerCard1 + dealerCard2;
        int userScore = userCard1 + userCard2;

        userChoice(dealerScore, userScore, dealerCard2);

        System.out.println(checkWin(userScore, dealerScore));
    }

    public static void userChoice(int dealerScore, int userScore, int dealerCard2){
        while (true) {
            String decision = hitOrStay();
            if (decision.equals("stay")) {
                System.out.println("Dealers hidden card was: \n" + drawRandomCard(dealerCard2) + "\n So his score is: " + dealerScore + ".");
                if (dealerScore <= 17) {
                    System.out.println("Dealers next cad is: ");
                    int points = randomNumber();
                    System.out.println(drawRandomCard(points));
                    userScore +=points;
                    System.out.println("And his score is : " + userScore + ".");
                    break;
                }
                else{
                    break;
                }
            }

            if (decision.equals("hit")) {
                System.out.println("Your next card is: ");
                int points = randomNumber();
                System.out.println(drawRandomCard(points));
                userScore +=points;
                System.out.println("And your score is : " + userScore + ".");
                if(userScore > 21){
                    break;
                }

            }

        }
    }

    public static String checkWin(int userScore, int dealerScore){
        if(userScore > 21){
            return "Dealer wins!";
        }
        else if(dealerScore > userScore){
            return "Dealer wins!";
        }
        else if(userScore > dealerScore){
            return "You win!";
        }
        else{
            return "There is a draw";
        }
    }

    public static int randomNumber() {
        double randomNumber = Math.random() * 13;
        randomNumber += 1;
        return (int) randomNumber;
    }

    public static String hitOrStay() {
        System.out.println("Would you like to hit or stay?");

        Scanner scanner = new Scanner(System.in);

        String userDecision = scanner.nextLine();

        while (!userDecision.equals("hit") && !userDecision.equals("stay")) {
            System.out.print("Please type correct value: ");
            userDecision = scanner.nextLine();
        }

        if (userDecision.equals("stay")) {
            return "stay";
        }
        if (userDecision.equals("hit")) {
            return "hit";
        }
        return "sth gone wrong";
    }

    public static String drawRandomCard(int randomCard) {

        switch (randomCard) {
            case 1:
                return ("                      _____ \n" +
                        "                     |A _  |\n" +
                        "                     | ( ) |\n" +
                        "                     |(_'_)|\n" +
                        "                     |  |  |\n" +
                        "                     |____V|\n");
            case 2:
                return ("                       _____ \n" +
                        "                      |2    |\n" +
                        "                      |  o  |\n" +
                        "                      |     |\n" +
                        "                      |  o  |\n" +
                        "                      |____Z|\n");


            case 3:
                return ("                     _____ \n" +
                        "                    |3    |\n" +
                        "                    | o o |\n" +
                        "                    |     |\n" +
                        "                    |  o  |\n" +
                        "                    |____E|\n");
            case 4:
                return ("                      _____ \n" +
                        "                     |4    |\n" +
                        "                     | o o |\n" +
                        "                     |     |\n" +
                        "                     | o o |\n" +
                        "                     |____h|\n");

            case 5:
                return ("                       _____ \n" +
                        "                      |5    |\n" +
                        "                      | o o |\n" +
                        "                      |  o  |\n" +
                        "                      | o o |\n" +
                        "                      |____S|\n");
            case 6:
                return ("                       _____ \n" +
                        "                      |6    |\n" +
                        "                      | o o |\n" +
                        "                      | o o |\n" +
                        "                      | o o |\n" +
                        "                      |____6|\n");
            case 7:
                return ("                       _____ \n" +
                        "                      |7    |\n" +
                        "                      | o o |\n" +
                        "                      |o o o|\n" +
                        "                      | o o |\n" +
                        "                      |____7|\n");

            case 8:
                return ("                       _____ \n" +
                        "                      |8    |\n" +
                        "                      |o o o|\n" +
                        "                      | o o |\n" +
                        "                      |o o o|\n" +
                        "                      |____8|\n");

            case 9:
                return ("                       _____ \n" +
                        "                      |9    |\n" +
                        "                      |o o o|\n" +
                        "                      |o o o|\n" +
                        "                      |o o o|\n" +
                        "                      |____9|\n");

            case 10:
                return ("                       _____ \n" +
                        "                      |10  o|\n" +
                        "                      |o o o|\n" +
                        "                      |o o o|\n" +
                        "                      |o o o|\n" +
                        "                      |___10|\n");

            case 11:
                return ("                       _____\n" +
                        "                      |J  ww|\n" +
                        "                      | o {)|\n" +
                        "                      |o o% |\n" +
                        "                      | | % |\n" +
                        "                      |__%%[|\n");
            case 12:
                return ("                       _____\n" +
                        "                      |Q  ww|\n" +
                        "                      | o {(|\n" +
                        "                      |o o%%|\n" +
                        "                      | |%%%|\n" +
                        "                      |_%%%O|\n");

            case 13:
                return ("                       _____\n" +
                        "                      |K  WW|\n" +
                        "                      | o {)|\n" +
                        "                      |o o%%|\n" +
                        "                      | |%%%|\n" +
                        "                      |_%%%>|\n");

            default: return "sth gone wrong";
        }
    }

    public static String faceDown() {
        return
                "   _____\n" +
                        "  |     |\n" +
                        "  |  J  |\n" +
                        "  | JJJ |\n" +
                        "  |  J  |\n" +
                        "  |_____|\n";
    }
}