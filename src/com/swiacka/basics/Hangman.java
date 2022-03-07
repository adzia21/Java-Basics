package com.swiacka.basics;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"};


    public static void main(String[] args) {

        String drawnWord = findRandomWord();
        char[] dividedWord = convertStringToChar(drawnWord);
        System.out.println(drawnWord);
        char[] drawnWordUnderscores = convertCharToUnderscore(dividedWord);

        int count = 0;
        char[] missedLetters = {' ', ' ', ' ', ' ', ' ', ' ', ' '};

        count = checkUserChoice(dividedWord, drawnWordUnderscores, count, missedLetters);

        checkWin(count, drawnWordUnderscores);

    }

    private static void checkWin(int count, char[] drawnWordUnderscores) {
        if (count >= 6) {
            System.out.println("_____________");
            System.out.println("You loose");
        } else {
            System.out.println("____________________");
            System.out.print("Word: \t");
            System.out.println(drawnWordUnderscores);
            System.out.println("You won!");
        }
    }

    private static int checkUserChoice(char[] dividedWord, char[] drawnWordUnderscores, int count, char[] missedLetters) {
        while (!Arrays.equals(dividedWord, drawnWordUnderscores)) {
            if (count >= 6) {
                break;
            }
            System.out.println(gallows[count]);

            System.out.print("Word: \t");
            System.out.println(drawnWordUnderscores);

            System.out.println("Misses: ");
            System.out.println(missedLetters);

            System.out.print("Guess: ");
            char userLetter = scanner.next().charAt(0);

            boolean isLetterIntoWord = false;

            for (int i = 0; i < dividedWord.length; i++) {
                if (userLetter == dividedWord[i]) {
                    drawnWordUnderscores[i] = userLetter;
                    isLetterIntoWord = true;
                }
            }
            if (!isLetterIntoWord) {
                missedLetters[count] = userLetter;
                count++;
            }
        }
        return count;
    }

    private static char[] convertCharToUnderscore(char[] dividedWord) {
        char[] underscores = new char[dividedWord.length];
        Arrays.fill(underscores, '_');
        return underscores;
    }

    private static char[] convertStringToChar(String drawnWord) {
        char[] dividedWord = new char[drawnWord.length()];
        for (int i = 0; i < drawnWord.length(); i++) {
            dividedWord[i] = drawnWord.charAt(i);
        }
        return dividedWord;
    }

    private static String findRandomWord() {
        double randomNumber = Math.random() * Hangman.words.length;
        randomNumber += 1;
        return Hangman.words[(int) randomNumber];
    }

    private static final String[] gallows = {"+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n"};

}