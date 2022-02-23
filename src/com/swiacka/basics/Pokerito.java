package com.swiacka.basics;


import java.util.Scanner;

public class Pokerito {
    public static void main(String[] args) {

        System.out.println("Let's play Pokerito. It's like Poker, but a lot simpler.");

        System.out.println("                - There are two players, you and the computer.");
        System.out.println("                - The dealer will give each player one card.");
        System.out.println("                - Then, the dealer will draw five cards (the river)");
        System.out.println("                - The player with the most river matches wins!");
        System.out.println("                - If the matches are equal, everyone's a winner!");
        System.out.println("                - Ready? Type anything if you are.");

        Scanner scanner = new Scanner(System.in);

        String userReady = scanner.nextLine();



        int userPoints = 0;
        int computerPoints = 0;

        while(true){

            String userCard = randomCard();
            System.out.println("Here is your card: ");
            System.out.println(userCard);

            String computerCard = randomCard();
            System.out.println("Here is the computer's card: ");
            System.out.println(computerCard);

            System.out.println("Now the dealer will draw five cards. Press enter to continue");

            scanner.nextLine();


                for (int i = 1; i <=5; i++){
                    scanner.nextLine();
                    String loopCard = randomCard();

                    System.out.println("Card number " + i + ": ");

                    System.out.println(loopCard);
                    if(loopCard.equals(userCard)){
                        userPoints++;
                    }
                    else if (loopCard.equals(computerCard)){
                        computerPoints++;
                    }
                }

                System.out.println("Your number of matches: " + userPoints);
                System.out.println("Computer number of matches: " + computerPoints);

                if (computerPoints > userPoints){
                    System.out.println("The computer wins!");
                    break;
                }
                else if(computerPoints < userPoints){
                    System.out.println("You win!");
                    break;
                }
                else if (userPoints == computerPoints){
                    System.out.println("Everyone wins!");
                    break;
                }




        }



    }

    public static String randomCard() {
        double randomCard = Math.random() * 13;
        randomCard += 1;

        switch ((int) randomCard) {
            case 1:
                String card1 = ("                      _____ \n" +
                        "                     |A _  |\n" +
                        "                     | ( ) |\n" +
                        "                     |(_'_)|\n" +
                        "                     |  |  |\n" +
                        "                     |____V|\n");
                return card1;

            case 2:
                String card2 = ("                       _____ \n" +
                        "                      |2    |\n" +
                        "                      |  o  |\n" +
                        "                      |     |\n" +
                        "                      |  o  |\n" +
                        "                      |____Z|\n");
                return card2;

            case 3:
                String card3 = ("                     _____ \n" +
                        "                    |3    |\n" +
                        "                    | o o |\n" +
                        "                    |     |\n" +
                        "                    |  o  |\n" +
                        "                    |____E|\n");
                return card3;
            case 4:
                String card4 = ("                      _____ \n" +
                        "                     |4    |\n" +
                        "                     | o o |\n" +
                        "                     |     |\n" +
                        "                     | o o |\n" +
                        "                     |____h|\n");
                return card4;
            case 5:
                String card5 = ("                       _____ \n" +
                        "                      |5    |\n" +
                        "                      | o o |\n" +
                        "                      |  o  |\n" +
                        "                      | o o |\n" +
                        "                      |____S|\n");
                return card5;
            case 6:
                String card6 = ("                       _____ \n" +
                        "                      |6    |\n" +
                        "                      | o o |\n" +
                        "                      | o o |\n" +
                        "                      | o o |\n" +
                        "                      |____6|\n");
                return card6;
            case 7:
                String card7 = ("                       _____ \n" +
                        "                      |7    |\n" +
                        "                      | o o |\n" +
                        "                      |o o o|\n" +
                        "                      | o o |\n" +
                        "                      |____7|\n");
                return card7;
            case 8:
                String card8 = ("                       _____ \n" +
                        "                      |8    |\n" +
                        "                      |o o o|\n" +
                        "                      | o o |\n" +
                        "                      |o o o|\n" +
                        "                      |____8|\n");
                return card8;
            case 9:
                String card9 = ("                       _____ \n" +
                        "                      |9    |\n" +
                        "                      |o o o|\n" +
                        "                      |o o o|\n" +
                        "                      |o o o|\n" +
                        "                      |____9|\n");
                return card9;
            case 10:
                String card10 = ("                       _____ \n" +
                        "                      |10  o|\n" +
                        "                      |o o o|\n" +
                        "                      |o o o|\n" +
                        "                      |o o o|\n" +
                        "                      |___10|\n");
                return card10;
            case 11:
                String card11 = ("                       _____\n" +
                        "                      |J  ww|\n" +
                        "                      | o {)|\n" +
                        "                      |o o% |\n" +
                        "                      | | % |\n" +
                        "                      |__%%[|\n");
                return card11;
            case 12:
                String card12 = ("                       _____\n" +
                        "                      |Q  ww|\n" +
                        "                      | o {(|\n" +
                        "                      |o o%%|\n" +
                        "                      | |%%%|\n" +
                        "                      |_%%%O|\n");
                return card12;
            case 13:
                String card13 = ("                       _____\n" +
                        "                      |K  WW|\n" +
                        "                      | o {)|\n" +
                        "                      |o o%%|\n" +
                        "                      | |%%%|\n" +
                        "                      |_%%%>|\n");
                return card13;

        }
        return "random card";
    }
}
