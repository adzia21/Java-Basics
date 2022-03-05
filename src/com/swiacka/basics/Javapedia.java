package com.swiacka.basics;

import java.util.Scanner;

public class Javapedia {

    public static void main(String[] args) {
        int numberOfHistoricalFigures = howManyPeople();

        String[][] database = new String[numberOfHistoricalFigures][3];

        getValues(database);

        storedValue(database);

        checkInformation(database);

    }

    public static int howManyPeople(){
        System.out.println("*********Javapedia*********" +
                "\nHow many historical figures will you register?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String[][] getValues(String[][]database){
        for (int i = 0; i < database.length; i++){
            System.out.println("\nFigure: " + (i+1));
            Scanner scanner = new Scanner(System.in);
            System.out.print(" - Name: ");
            String name = scanner.nextLine();
            database[i][0] = name;
            System.out.print(" - Date of birth: ");
            String dateOfBirth = scanner.nextLine();
            database[i][1] = dateOfBirth;
            System.out.print(" - Occupation: ");
            String Occupation = scanner.nextLine();
            database[i][2] = Occupation;
        }

        return database;
    }

    public static void storedValue(String[][]database){
        System.out.print("\n\nThese are values you stored: \n");
        for (int i = 0; i < database.length; i++){
            System.out.println("\t" + database[i][0] + " " + database[i][1] + " " + database[i][2] + " ");
        }
    }

    public static String[][] checkInformation(String[][]database){
        System.out.print("\n\nWhat do you want information on? ");
        Scanner scanner = new Scanner(System.in);
        String searchingValue = scanner.nextLine();

        for(int i = 0; i < database.length; i++){
            if(database[i][0].equals(searchingValue)){
                System.out.println("\t Name: " + database[i][0]);
                System.out.println("\t Date of birth: " + database[i][1]);
                System.out.println("\t Occupation: " + database[i][2]);

            }
            else{
                System.out.println("There is no person you are looking for in a database.");
            }
        }

        return database;
    }


}
