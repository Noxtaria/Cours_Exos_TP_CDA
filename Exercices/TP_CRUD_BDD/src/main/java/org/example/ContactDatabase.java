package org.example;

import org.example.entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactDatabase {
    private List<Contact> contacts = new ArrayList<>();
    private Long nextId = 1L;

    public void insertContact(String name, String number) {
        contacts.add(new Contact(nextId++, name, number));
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    public List<Contact> searchContacts(String searchTerm) {
        List<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    contact.getNumber().contains(searchTerm)) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    public void updateContact(int id, String newName, String newNumber) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contact.setName(newName);
                contact.setNumber(newNumber);
                break;
            }
        }
    }

    public void deleteContact(int id) {
        Contact contactToRemove = null;
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contactToRemove = contact;
                break;
            }
        }
        if (contactToRemove != null) {
            contacts.remove(contactToRemove);
        }
    }
}
