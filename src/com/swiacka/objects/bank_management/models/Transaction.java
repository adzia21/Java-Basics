package com.company.objects.bank_management.models;

import com.company.objects.bank_management.models.account.Account;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

import static java.time.Instant.ofEpochSecond;
import static java.time.ZonedDateTime.ofInstant;

public class Transaction implements Comparable<Transaction> {
    private TransactionType type;
    private long timestamp;
    private String id;
    private BigDecimal amount;

    public Transaction(TransactionType type, long timestamp, String id, BigDecimal amount) {
        if(id.isEmpty() || id.isBlank() || id == null){
            throw new IllegalArgumentException("INVALID VALUE");
        }
        if(amount.compareTo(new BigDecimal("0")) < 0){
            throw new IllegalArgumentException("AMOUNT CAN NOT BE NEGATIVE VALUE");
        }
        this.type = type;
        this.timestamp = timestamp;
        this.id = id;
        this.amount = new BigDecimal(String.valueOf(amount));
    }

    public Transaction(Transaction transaction){
        this.type = transaction.type;
        this.timestamp = transaction.timestamp;
        this.id = transaction.id;
        this.amount = new BigDecimal(String.valueOf(transaction.amount));
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.isEmpty() || id.isBlank() || id == null){
            throw new IllegalArgumentException("INVALID VALUE");
        }
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        if(getAmount().compareTo(new BigDecimal("0")) < 0){
            throw new IllegalArgumentException("AMOUNT CAN NOT BE NEGATIVE VALUE");
        }
        this.amount = amount;
    }


    public String returnDate(long miliseconds){
        ZonedDateTime zonedDateTime = ofInstant(ofEpochSecond(miliseconds), ZoneId.of("Europe/Paris"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return zonedDateTime.format(formatter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return timestamp == that.timestamp && type == that.type && id.equals(that.id) && amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, timestamp, id, amount);
    }

    @Override
    public String toString() {
        return type + "    " +
                "\t" + returnDate(getTimestamp()) + "" +
                "\t" + id + "" +
                "\t$" + amount + "";
    }

    @Override
    public int compareTo(@NotNull Transaction o) {
        return Double.compare(this.timestamp, o.timestamp);
    }
}
