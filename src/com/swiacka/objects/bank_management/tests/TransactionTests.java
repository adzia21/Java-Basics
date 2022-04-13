package com.company.objects.bank_management.tests;

import com.company.objects.bank_management.models.Transaction;
import com.company.objects.bank_management.models.TransactionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class TransactionTests {
    Transaction transaction;

    @Before
    public void setup() {
        transaction = new Transaction(TransactionType.WITHDRAW, 1546905600, "6b8dd258-aba3-4b19-b238-45d15edd4b48", new BigDecimal("624.99"));
    }

    @Test
    public void correctDateTest() {
        Assert.assertEquals("08-01-2019", transaction.returnDate(transaction.getTimestamp()));
    }
}
