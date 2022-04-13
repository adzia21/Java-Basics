package com.company.objects.bank_management.models.account;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Account {
    private String id;
    private String name;
    private BigDecimal balance;

    public Account(String id, String name, BigDecimal balance) {

        if (id.isBlank() || id.isEmpty() || id == null || name.isBlank() || name.isEmpty() || name == null) {
            throw new IllegalArgumentException("INVALID VALUE");
        }
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account account) {
        this.id = account.id;
        this.name = account.name;
        this.balance = account.balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.isBlank() || id.isEmpty() || id == null) {
            throw new IllegalArgumentException("INVALID VALUE");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank() || name.isEmpty() || name == null) {
            throw new IllegalArgumentException("INVALID VALUE");
        }
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName()) + "    " +
                "\t" + this.getId() + "" +
                "\t" + this.getName() + "" +
                "\t$" + this.getBalance() + "";
    }

    public abstract void deposit(BigDecimal amount);

    public abstract boolean withdraw(BigDecimal amount);

    protected static BigDecimal round(BigDecimal amount) {
        return amount.setScale(2, RoundingMode.CEILING);
    }

    public abstract Account clone();
}
