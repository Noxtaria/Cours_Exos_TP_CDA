package org.example.layout;

import org.example.ContactDatabase;
import org.example.entity.Contact;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SelectFrame extends JFrame {
    private JTextArea resultTextArea = new JTextArea(10, 30);
    private ContactDatabase contactDatabase;

    public SelectFrame(ContactDatabase contactDatabase) {
        this.contactDatabase = contactDatabase;

        setTitle("Select Contacts");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        List<Contact> contacts = contactDatabase.getAllContacts();
        displayContacts(contacts);

        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void displayContacts(List<Contact> contacts) {
        resultTextArea.setText("");

        if (contacts.isEmpty()) {
            resultTextArea.append("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                resultTextArea.append("ID: " + contact.getId() + "\n");
                resultTextArea.append("Name: " + contact.getName() + "\n");
                resultTextArea.append("Number: " + contact.getNumber() + "\n\n");
            }
        }
    }
}

