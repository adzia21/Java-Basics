package com.company.objects.airline;


class Airline {
    private Person[] seats;

    public Airline() {
        this.seats = new Person[12];
    }

    public Airline(Person[] seats) {
        this.seats = new Person[seats.length];
        for (int i = 0; i < seats.length; i++) {
            this.seats[i] = new Person(seats[i]);
        }
    }

    public Person getPersons(int index) {
        return new Person(this.seats[index]);
    }

    public void setSeats(Person seats, int index) {
        this.seats[index] = new Person(seats);
    }
    public void createReservation(Person person){
        while(seats[person.getSeatNumber()] != null){
            System.out.println("\n" + person.getName() + ", seat: " + person.getSeatNumber() + " is already taken. Please choose another one \n");
             person.setSeatNumber(person.chooseSeat());
        }
        seats[person.getSeatNumber()] = new Person(person);



        System.out.println("Thank you " + person.getName() + " for flying with Java airlines. Your seat number is " + person.getSeatNumber());
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 1; i < seats.length; i++) {
            if(seats[i] == null){
                temp += "\nSeat " + i + " is empty.\n";
            }
            else{
                temp += seats[i].toString() + "\n";
            }
        }
        return temp;
    }
}
