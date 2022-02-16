package com.swiacka.basics;

import java.util.Scanner;

class TriviaQuiz {

    public static void main(String[] args) {
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Which country held the 2016 Summer Olympics?");
        System.out.println("a) China \nb) Ireland \nc) Brazil \nd) Italy");

        String questionOne = scanner.nextLine();

        System.out.println(questionOne);

        if (questionOne.equals("c")) {
            score += 5;
        }

        System.out.println("2. Which planet is the hottest?");
        System.out.println("a) Venus \nb) Saturn \nc) Mercury \nd) Mars");

        String questionTwo = scanner.nextLine();

        if (questionTwo.equals("a")) {
            score += 5;
        }

        System.out.println("3. What is the rarest blood type?");
        System.out.println("a) 0 \nb) A \nc) B \nd) AB-Negative");

        String questionThree = scanner.nextLine();

        if (questionThree.equals("d")) {
            score += 5;
        }

        System.out.println("4. Which one of these characters is friends with Harry Potter?");
        System.out.println("a) Ron Weasley \nb) Hermione Granger \nc) Draco Malfoy \nd) Neville Longbottom");

        String questionFour = scanner.nextLine();

        if (questionThree.equals("a") || questionThree.equals("b") || questionThree.equals("d")) {
            score += 5;
        }

        System.out.println("Your final score is: " + score + "/20");

        if (score >= 15) {
            System.out.println("Wow, you know your stuff!");
        } else if (score >= 5) {
            System.out.println("Not bad!");
        } else {
            System.out.println("Better luck next time.");
        }
    }
}
