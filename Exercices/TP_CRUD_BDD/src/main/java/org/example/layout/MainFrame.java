package org.example.layout;

import org.example.ContactDatabase;
import org.example.entity.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame implements ActionListener {
    private JButton insertButton = new JButton("Insert");
    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");
    private JButton searchButton = new JButton("Search");

    private ContactDatabase contactDatabase;

    public MainFrame(ContactDatabase contactDatabase) {
        this.contactDatabase = contactDatabase;

        setTitle("Contact CRUD App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(insertButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);

        insertButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);

        add(buttonPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertButton) {
            new InsertFrame(contactDatabase, this);
        } else if (e.getSource() == updateButton) {
            new UpdateFrame(contactDatabase, this);
        } else if (e.getSource() == deleteButton) {
            new DeleteFrame(contactDatabase, this);
        } else if (e.getSource() == searchButton) {
            List<Contact> contacts = contactDatabase.getAllContacts();
            new SelectFrame(contacts);
        }
    }
}
