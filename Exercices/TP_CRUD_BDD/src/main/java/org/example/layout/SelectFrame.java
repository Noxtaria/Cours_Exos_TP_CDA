package org.example.layout;

import org.example.entity.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SelectFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public SelectFrame(List<Contact> contacts) {
        setTitle("Select Contacts");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Number"}, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        populateTable(contacts);

        setVisible(true);
    }

    private void populateTable(List<Contact> contacts) {
        for (Contact contact : contacts) {
            Object[] rowData = {contact.getId(), contact.getName(), contact.getNumber()};
            tableModel.addRow(rowData);
        }
    }
}
