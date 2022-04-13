package com.company.objects.bank_management;

import com.company.objects.bank_management.models.Bank;
import com.company.objects.bank_management.models.Transaction;
import com.company.objects.bank_management.models.TransactionType;
import com.company.objects.bank_management.models.account.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    static Bank bank = new Bank();

    public static void main(String[] args) {

        try {
            ArrayList<Account> accounts = returnAccounts();
            loadAccounts(accounts);

            ArrayList<Transaction> transactions = returnTransactions();
            runTransactions(transactions);
            bank.deductTaxes();
            for (Account account : accounts) {
                System.out.println("\n\t\t\t\t\t ACCOUNT\n\n\t" + account + "\n\n");
                transactionHistory(account.getId());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Account createObject(String[] values) {
        try {
            return (Account) Class.forName("com.company.objects.bank_management.models.account." + values[0])
                    .getConstructor(String.class, String.class, BigDecimal.class)
                    .newInstance(values[1], values[2], new BigDecimal(values[3]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Account> returnAccounts() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/com/company/objects/bank_management/resources/accounts.txt"));
        ArrayList<Account> accounts = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitter = line.split(",");
            accounts.add(createObject(splitter));
        }
        return accounts;
    }

    public static void loadAccounts(ArrayList<Account> accounts) throws FileNotFoundException {
        for (Account account : accounts) {
            bank.addAccount(account);
        }
    }

    public static ArrayList<Transaction> returnTransactions() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/com/company/objects/bank_management/resources/transactions.txt"));
        ArrayList<Transaction> transactions = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitter = line.split(",");
            Transaction transaction = null;
            if (splitter[1].equals("WITHDRAW")) {
                transaction = new Transaction(TransactionType.WITHDRAW, Long.parseLong(splitter[0]), splitter[2], new BigDecimal(splitter[3]));
            }
            if (splitter[1].equals("DEPOSIT")) {
                transaction = new Transaction(TransactionType.DEPOSIT, Long.parseLong(splitter[0]), splitter[2], new BigDecimal(splitter[3]));
            }
            transactions.add(transaction);
        }
        Collections.sort(transactions);

        return transactions;
    }

    public static void runTransactions(ArrayList<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            bank.executeTransaction(transaction);
        }
    }

    public static void transactionHistory(String id) {
        System.out.println("\t\t\t\t   TRANSACTION HISTORY\n\t");
        for (Transaction transaction : bank.getTransactions(id)) {
            wait(300);
            System.out.println("\t" + transaction + "\n");
        }
        System.out.println("\n\t\t\t\t\tAFTER TAX\n");
        System.out.println("\t" + bank.getAccount(id) + "\n\n\n\n");
    }


    public static void wait(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
