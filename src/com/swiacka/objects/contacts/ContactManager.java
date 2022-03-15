package com.company.objects.contacts;

import java.util.ArrayList;


public class ContactManager {
    ArrayList<Contact> contacts;

    public ContactManager() {
    this.contacts = new ArrayList<>();
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public void setContact(int index, Contact contact) {
        contacts.add(index, new Contact(contact));
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    public boolean removeContact(String contactName){
        if(contacts.isEmpty()){
            throw new IllegalStateException();
        }
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getName().equals(contactName)){
                contacts.remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < contacts.size(); i++) {
            temp += contacts.get(i).toString() + "\n\n";
        }
        return temp;
    }
}
