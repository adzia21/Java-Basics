package com.company.objects.bank_management.models;

import com.company.objects.bank_management.models.account.Account;
import com.company.objects.bank_management.models.account.Chequing;
import com.company.objects.bank_management.models.account.Taxable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Bank {
    ArrayList<Account> accounts;
    ArrayList<Transaction> transactions;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account.clone());
    }

    private void addTransaction(Transaction transaction) {
        transactions.add(new Transaction(transaction));
    }

    public Transaction[] getTransactions(String accountId) {
        return transactions.stream().filter(transaction -> transaction.getId().equals(accountId)).toArray(Transaction[]::new);
    }

    public Account getAccount(String transactionId) {
        return accounts.stream().filter(transaction -> transaction.getId().equals(transactionId)).findFirst().orElse(null);
    }

    private void withdrawTransaction(Transaction transaction) {
        if (getAccount(transaction.getId()).withdraw(transaction.getAmount())) {
            addTransaction(transaction);
        }
    }

    private void depositTransaction(Transaction transaction) {
        getAccount(transaction.getId()).deposit(transaction.getAmount());
        addTransaction(transaction);
    }

    public void executeTransaction(Transaction transaction) {
        if (transaction.getType().equals(TransactionType.DEPOSIT)) {
            depositTransaction(transaction);
        }
        if (transaction.getType().equals(TransactionType.WITHDRAW)) {
            withdrawTransaction(transaction);
        }
    }

    private BigDecimal getIncome(Taxable account) {
        Transaction[] transactions = getTransactions(((Chequing) account).getId());
        return Arrays.stream(transactions).map(transaction -> {
            switch (transaction.getType()){
                case WITHDRAW: return transaction.getAmount().negate();
                case DEPOSIT: return transaction.getAmount();
                default: return BigDecimal.ZERO;
            }
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    public void deductTaxes(){
        for(Account account : accounts){
            if (Taxable.class.isAssignableFrom(account.getClass())){
                Taxable taxable = (Taxable)account;
                taxable.tax(getIncome(taxable));
            }
        }

    }


}
