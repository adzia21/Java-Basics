package com.company.objects.bank_management.tests;

import com.company.objects.bank_management.models.account.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class AccountTests {

    Account[] accounts;

    @Before
    public void setup(){
        accounts = new Account[] {
                new Chequing("f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott", new BigDecimal("1524.51")),
                new Savings("ce07d7b3-9038-43db-83ae-77fd9c0450c9", "Saul Goodman", new BigDecimal("2241.60")),
                new Loan("4991bf71-ae8f-4df9-81c1-9c79cff280a5", "Phoebe Buffay", new BigDecimal("2537.31"))
        };
    }

    @Test
    public void withdrawal(){
        accounts[0].withdraw(new BigDecimal("1440"));
        Assert.assertEquals(new BigDecimal("84.51"), accounts[0].getBalance());
    }

    @Test
    public void overdraft(){
        accounts[0].withdraw(new BigDecimal("1534.43"));
        Assert.assertEquals(new BigDecimal("-15.42"), accounts[0].getBalance());
    }

    @Test
    public void overdraftLimit(){
        accounts[0].withdraw(new BigDecimal("1726.00"));
        Assert.assertEquals(new BigDecimal("1524.51"), accounts[0].getBalance());
    }

    @Test
    public void withdrawalFee(){
        accounts[1].withdraw(new BigDecimal("100.00"));
        Assert.assertEquals(new BigDecimal("2136.60"), accounts[1].getBalance());
    }

    @Test
    public void withdrawalInterest(){
        accounts[2].withdraw(new BigDecimal("2434.31"));
        Assert.assertEquals(new BigDecimal("5020.31"), accounts[2].getBalance());
    }

    @Test
    public void withdrawalLimit(){
        accounts[2].withdraw(new BigDecimal("7463.69"));
        Assert.assertEquals(new BigDecimal("2537.31"), accounts[2].getBalance());
    }

    @Test
    public void deposit(){
        accounts[0].deposit(new BigDecimal("5000.00"));
        accounts[1].deposit(new BigDecimal("5000.00"));
        Assert.assertEquals(new BigDecimal("6524.51"), accounts[0].getBalance());
        Assert.assertEquals(new BigDecimal("7241.60"), accounts[1].getBalance());
    }

    @Test
    public void loanDeposit(){
        accounts[2].deposit(new BigDecimal("1000.00"));
        Assert.assertEquals(new BigDecimal("1537.31"), accounts[2].getBalance());
    }

    @Test
    public void incomeTax(){
        BigDecimal income = new BigDecimal("4000.00");
        accounts[0].deposit(income);
        ((Taxable)accounts[0]).tax(income);
        Assert.assertEquals(new BigDecimal("5374.51"), accounts[0].getBalance());
    }

}
