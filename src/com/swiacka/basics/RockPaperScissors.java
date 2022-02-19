package com.swiacka.basics;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.");
        System.out.println("\nAre you ready? Write 'yes' if you are.");

        Scanner scanner = new Scanner(System.in);

        String readyQuestion = scanner.nextLine();

        if (readyQuestion.equals("yes")) {
            System.out.println("Great!");
            System.out.println("rock -- paper -- scissors, shoot!");

            String userChoice = scanner.nextLine();

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Bad value! Try again: ");
                userChoice = scanner.nextLine();
            }

            String computerChoice = computerChoice();

            System.out.println("You chose: " + userChoice + "\n Computer chose: " + computerChoice);

            result(userChoice, computerChoice);


        } else {
            System.out.println("Darn, some other time...!");
        }
    }

    public static String computerChoice() {
        int randomNumber = (int) (Math.random() * 3);
        randomNumber += 1;
        String choice = " ";
        if (randomNumber == 1) {
            choice = "rock";
        } else if (randomNumber == 2) {
            choice = "paper";
        } else if (randomNumber == 3) {
            choice = "scissors";
        }
        return choice;
    }

    public static void result(String userChoice, String computerChoice) {
        if (computerChoice.equals(userChoice)) {
            System.out.println("There is a tie!");
        } else if ((computerChoice.equals("rock") && userChoice.equals("paper")) || (computerChoice.equals("paper") && userChoice.equals("scissors")) || (computerChoice.equals("scissors") && userChoice.equals("rock"))) {
            System.out.println("Congrats! You won!");
        } else {
            System.out.println("Not lucky today. Try again!");
        }
    }

}
