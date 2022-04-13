package com.company.objects.bank_management.models.account;

import java.math.BigDecimal;

public class Savings extends Account{
    public Savings(String id, String name, BigDecimal balance) {
        super(id, name, balance);
    }

    public Savings(Account account) {
        super(account);
    }

    @Override
    public void deposit(BigDecimal amount) {
        setBalance(getBalance().add(amount));
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        setBalance(getBalance().subtract(amount).subtract(new BigDecimal("5.00")));
        return true;
    }

    @Override
    public Account clone() {
        return new Savings(this.getId(), this.getName(), this.getBalance());
    }
}
