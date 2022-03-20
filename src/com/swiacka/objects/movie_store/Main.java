package com.company.objects.movie_store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Store store = new Store();

    public static void main(String[] args) {
        System.out.println("***********JAVA VIDEO STORE***********");


        try {
            loadMovies("movies.txt");
            manageMovies();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } finally {
            System.out.println("\n\n UPDATED MOVIES\n\n");
            System.out.println(store);
        }
        manageMovies();
    }

    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitter = line.split("--");
            Movie movieFromFile = new Movie(splitter[0], splitter[1], Double.parseDouble(splitter[2]));
            store.addMovie(movieFromFile);
        }
    }

    public static void manageMovies() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(store);
            System.out.println("Would you like to: \n\ta) purchase\n\tb) rent\n\tc) return");
            String userChoice = scanner.nextLine();
            try {

                if (userChoice.equals("a")) {

                    System.out.println("What do you want to buy?");
                    String movieName = scanner.nextLine();
                    store.checkException(movieName, userChoice);
                    store.sellMovie(movieName);
                }
                if (userChoice.equals("b")) {
                    System.out.println("What do you want to rent?");
                    String movieName = scanner.nextLine();
                    store.checkException(movieName, userChoice);
                    store.rentMovie(movieName);
                }
                if (userChoice.equals("c")) {
                    System.out.println("What do you want to return?");
                    String movieName = scanner.nextLine();
                    store.checkException(movieName, userChoice);
                    store.returnMovie(movieName);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n\nThe input you provided is not valid. Please try again.\n");
            } catch (IllegalStateException e) {
                System.out.println("\n\nThe movie is not available for purchase. Please try again\n");
            }

        }

    }
}
