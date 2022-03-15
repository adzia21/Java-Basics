package com.company.objects.contacts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;

    public Contact(String name, String phoneNumber, String birthDate) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        } else if (phoneNumber == null || phoneNumber.length() < 5) {
            throw new IllegalArgumentException("phone number cannot be null or less than 5");
        } else {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.birthDate = birthDate;
            calculateAge();
        }

    }

    public Contact(Contact contact) {
        this.name = contact.getName();
        this.phoneNumber = contact.getPhoneNumber();
        this.birthDate = contact.getBirthDate();
        calculateAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
        }

    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        calculateAge();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() < 5) {
            throw new IllegalArgumentException();
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    private void calculateAge() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        simpleDateFormat.setLenient(false);

        Date birthDateFormat;
        try {
            birthDateFormat = simpleDateFormat.parse(this.birthDate);
            long milisecondFrom1970ToBirthDate = birthDateFormat.getTime();

            double milisecondFrom1970ToBirthDateToDays = TimeUnit.MILLISECONDS.toDays(milisecondFrom1970ToBirthDate);

            int yearsFrom1970To2000 = (int) milisecondFrom1970ToBirthDateToDays / 365;


            long millisecondFromJanuary1970ToNow = new Date().getTime();

            double daysFromJanuary1970ToNow = TimeUnit.MILLISECONDS.toDays(millisecondFromJanuary1970ToNow);

            int daysFromJanuary1970ToNowInInt = (int) daysFromJanuary1970ToNow / 365;


            this.age = daysFromJanuary1970ToNowInInt - yearsFrom1970To2000;

        } catch (ParseException e) {
            System.out.println("Unparseable date: " + birthDate);
            System.out.println("Process Complete");
        }


    }

    @Override
    public String toString() {
        return "CONTACT " + '\n' +
                "Name: " + name + '\n' +
                "Age: " + age + '\n' +
                "BirthDate: " + birthDate + '\n' +
                "PhoneNumber: " + phoneNumber + '\n'
                ;
    }
}
