package com.swiacka.basics;

import java.util.Scanner;

/**
 * Dice Jack - how to play:
 * 1. user needs to pick three numbers
 * 2. user needs to roll the dice three times
 *
 * Dice Jack - when user wins:
 * 1. the sum of dice rolls is smaller than the sum of numbers user chose
 * 2. the difference between the two number is less than three
 * !!! BOTH CONDITIONS MUST BE DONE !!!
 */

public class DiceJack {

    public static void main(String[] args) {
        int roll1 = rollDice();
        int roll2 = rollDice();
        int roll3 = rollDice();

        System.out.println("Enter three numbers between 1 and 6");

        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        if(num1 < 1 || num2 < 1 || num3 < 1){
            System.out.println("Numbers cannot be less than 1. Shutting game down.");
            System.exit(0);
        }
        if(num1 > 6 || num2 > 6 || num3 > 6){
            System.out.println("Numbers cannot be higher than 6. Shutting game down.");
            System.exit(0);
        }

        System.out.println("Dice");
        System.out.println(roll1);
        System.out.println(roll2);
        System.out.println(roll3);

        int sumOfNumbers = num1+num2+num3;
        int sumDiceRolls = roll1+roll2+roll3;

        System.out.println( "Dice sum = " + sumDiceRolls + ". Number sum = " + sumOfNumbers + " .");
        checkWin(sumDiceRolls, sumOfNumbers);

        scanner.close();
    }

    public static int rollDice(){
     double randomNumber = Math.random() * 6;
     randomNumber +=1;
     return (int)randomNumber;
    }

    public static void checkWin(int sumDiceRolls, int sumOfNumbers){
        if(sumOfNumbers > sumDiceRolls && sumOfNumbers - sumDiceRolls < 3){
            System.out.println("Congrats, you win!");
        }
        else{
            System.out.println("Sorry you loose :(.");
        }
    }
}
