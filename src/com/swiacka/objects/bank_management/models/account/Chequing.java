package com.company.objects.bank_management.models.account;

import java.math.BigDecimal;

public class Chequing extends Account implements Taxable {
    public Chequing(String id, String name, BigDecimal balance) {
        super(id, name, balance);
    }

    public Chequing(Account account) {
        super(account);
    }

    @Override
    public void deposit(BigDecimal amount) {
        setBalance(getBalance().add(amount));
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        super.setBalance(getBalance().subtract(amount));
        if (super.getBalance().compareTo(new BigDecimal("-200.00")) < 0) {
            super.setBalance(getBalance().add(amount));
            return false;
        }
        if (super.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            super.setBalance(getBalance().subtract(new BigDecimal("5.50")));
            return true;
        }
        return true;
    }


    @Override
    public void tax(BigDecimal income) {
        if (income.compareTo(new BigDecimal("3000.00")) > 0) {
            BigDecimal tax = Account.round(income.subtract(new BigDecimal("3000.00")).multiply(new BigDecimal("0.15")));
            setBalance(getBalance().subtract(tax));
        }
    }

    @Override
    public Account clone() {
        return new Chequing(this.getId(), this.getName(), this.getBalance());
    }
}
