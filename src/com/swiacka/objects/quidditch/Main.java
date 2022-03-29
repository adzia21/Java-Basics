package com.company.objects.quidditch;


import com.company.objects.quidditch.models.Game;
import com.company.objects.quidditch.models.Team;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static Game game;
    static final String TEAMS_FILE = "src/com/company/objects/quidditch/resources/teams.txt";
    static final String PLAYS_FILE = "src/com/company/objects/quidditch/resources/plays.txt";

    public static void main(String[] args) {
        String[][] data = new String[0][];
        try {
            data = getData();
            game = new Game(
                    new Team(data[0][0], data[0][1], data[0][2], new String[]{data[0][3], data[0][4], data[0][5]}),
                    new Team(data[1][0], data[1][1], data[1][2], new String[]{data[1][3], data[1][4], data[1][5]})
            );
            startGame();
            printResult();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String[][] getData() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(TEAMS_FILE);
        Scanner scanner = new Scanner(fis);
        String[] lines = new String[]{scanner.nextLine(), scanner.nextLine()};
        scanner.close();
        return new String[][]{lines[0].split(","), lines[1].split(",")};
    }

    public static void startGame() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(PLAYS_FILE);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()) {
            wait(3);
            System.out.println("\n" + game.simulate(scanner.nextLine()) + "\n");
        }
        scanner.close();
    }

    public static void printResult() {
        Team gryffindor = game.getTeam("GRYFFINDOR");
        Team slytherin = game.getTeam("SLYTHERIN");
        Team winner = game.getScore(gryffindor) > game.getScore(slytherin) ? gryffindor : slytherin;
        System.out.println("\nGRYFFINDOR: " + game.getScore(gryffindor) + " SLYTHERIN: " + game.getScore(slytherin));
        System.out.println("\n" + game.getScore(winner) + " WINS!");

    }

    public static void wait(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
