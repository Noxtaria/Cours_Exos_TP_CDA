package org.example;

import org.example.connexion.ConnectionUtil;
import org.example.entity.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDatabase {

    private Connection connection;

    public ContactDatabase(){
        connection = ConnectionUtil.getConnection();
    }
    private List<Contact> contacts = new ArrayList<>();
    private Long nextId = 1L;

//    public void insertContact(String name, String number) {
//        contacts.add(new Contact(nextId++, name, number));
//    }

    public void insertContact(String name, String number) {
        String sql = "INSERT INTO contacts (name, number) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, number);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public List<Contact> getAllContacts() {
//        return new ArrayList<>(contacts);
//    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contacts";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String number = resultSet.getString("number");
                contacts.add(new Contact(id, name, number));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacts;
    }

//    public List<Contact> searchContacts(String searchTerm) {
//        List<Contact> searchResults = new ArrayList<>();
//        for (Contact contact : contacts) {
//            if (contact.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
//                    contact.getNumber().contains(searchTerm)) {
//                searchResults.add(contact);
//            }
//        }
//        return searchResults;
//    }

    public List<Contact> searchContacts(String searchTerm) {
        List<Contact> searchResults = new ArrayList<>();
        String sql = "SELECT * FROM contacts WHERE LOWER(name) LIKE ? OR number LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + searchTerm.toLowerCase() + "%");
            statement.setString(2, "%" + searchTerm + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    String number = resultSet.getString("number");
                    searchResults.add(new Contact(id, name, number));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchResults;
    }

//    public void updateContact(int id, String newName, String newNumber) {
//        for (Contact contact : contacts) {
//            if (contact.getId() == id) {
//                contact.setName(newName);
//                contact.setNumber(newNumber);
//                break;
//            }
//        }
//    }

    public void updateContact(Long id, String newName, String newNumber) {
        String sql = "UPDATE contacts SET name = ?, number = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newName);
            statement.setString(2, newNumber);
            statement.setLong(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void deleteContact(int id) {
//        Contact contactToRemove = null;
//        for (Contact contact : contacts) {
//            if (contact.getId() == id) {
//                contactToRemove = contact;
//                break;
//            }
//        }
//        if (contactToRemove != null) {
//            contacts.remove(contactToRemove);
//        }
//    }

    public void deleteContact(Long id) {
        String sql = "DELETE FROM contacts WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
