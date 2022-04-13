package com.company.objects.bank_management.models.account;

import java.math.BigDecimal;

public class Loan extends Account {
    public Loan(String id, String name, BigDecimal balance) {
        super(id, name, balance);
    }

    public Loan(Account account) {
        super(account);
    }

    @Override
    public void deposit(BigDecimal amount) {
        setBalance(getBalance().subtract(amount));
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        BigDecimal interestRate = Account.round(amount.multiply(new BigDecimal("0.02")));
        if (getBalance().add(amount).add(interestRate).compareTo(new BigDecimal("10000.00")) < 0) {
            setBalance(getBalance().add(amount).add(interestRate));
            return false;
        }
        return true;
    }

    @Override
    public Account clone() {
        return new Loan(this.getId(), this.getName(), this.getBalance());
    }

}
