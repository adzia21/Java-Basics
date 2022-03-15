package com.company.objects.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;


public class Main {
    static
    ContactManager contactManager = new ContactManager();

    public static void main(String[] args) throws ParseException, FileNotFoundException {

        loadContacts("file.txt");

        manageContacts();
    }

    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitter = line.split("\\s+");
            Contact contactFromFile = new Contact(splitter[0], splitter[1], splitter[2]);
            contactManager.addContact(contactFromFile);
        }
        scanner.close();

    }

    public static void manageContacts() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Would you like to \n\ta) add another contact\n\tb) remove a contact \n\tc) exit");
                String userChoice = scanner.nextLine();
                if (userChoice.equals("a")) {
                    System.out.print("\tName: ");
                    String name = scanner.nextLine();
                    System.out.print("\tPhone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("\tBirth date: ");
                    String birthDate = scanner.nextLine();
                    if (name.isBlank() || phoneNumber.isBlank() || phoneNumber.length() < 5) {
                        System.out.println("\nThe input you provided is not valid.");
                        continue;
                    }

                    Contact contactFromUser = new Contact(name, phoneNumber, birthDate);

                    contactManager.addContact(contactFromUser);
                }

                if (userChoice.equals("b")) {
                    System.out.println("Who would you like to remove?");
                    String contactNameToRemove = scanner.nextLine();

                    if (contactManager.removeContact(contactNameToRemove)) {
                        System.out.println(contactNameToRemove + " has been removed form contact list.");
                    }
                }
                if (userChoice.equals("c")) {
                    System.out.println("See ya later!");
                    break;
                }
            }
        } finally {
            System.out.println("\n\nUPDATED CONTACTS\n\n" + contactManager);
        }

        scanner.close();
    }

}


