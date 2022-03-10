package com.company.objects.airline;

import java.util.Arrays;

class Person {
    private String name;
    private String nationality;
    private String dateOfBirth;
    private String[] passport = new String[3];
    private int seatNumber;

    public Person(String name, String nationality, String dateOfBirth, int seatNumber) {
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.seatNumber = seatNumber;
    }

    public Person(String name, String nationality, String dateOfBirth, String[] passport, int seatNumber) {
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.passport = Arrays.copyOf(passport, passport.length);
        this.seatNumber = seatNumber;
    }

    public String[] getPassport() {
        return Arrays.copyOf(passport, passport.length);
    }

    public void setPassport() {
        String[] passport2 = new String[3];
        passport2[0] = this.name;
        passport2[1] = this.nationality;
        passport2[2] = this.dateOfBirth;
        this.passport = Arrays.copyOf(passport2, passport2.length);
    }

    public Person(Person source) {
        this.name = source.name;
        this.nationality = source.nationality;
        this.dateOfBirth = source.dateOfBirth;
        this.seatNumber = source.seatNumber;
        this.passport = source.passport;
    }

    public boolean applyPassport() {
        int randomNumber = (int) (Math.random() * 2);
        randomNumber += 1;
        return randomNumber == 1;
    }


    public int chooseSeat() {
        double randomSeat = Math.random() * 11;
        randomSeat += 1;
        return (int) randomSeat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Person: \n" +
                "\tname: " + name + '\n' +
                "\tnationality: " + nationality + '\n' +
                "\tdateOfBirth: " + dateOfBirth + '\n' +
                "\tpassport: " + Arrays.toString(passport) + '\n' +
                "\tseatNumber: " + seatNumber
                ;
    }
}


