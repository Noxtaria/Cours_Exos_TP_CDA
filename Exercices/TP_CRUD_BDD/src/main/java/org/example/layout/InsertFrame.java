package org.example.layout;

import org.example.ContactDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertFrame extends JFrame implements ActionListener {
    private JTextField nameField = new JTextField(15);
    private JTextField numberField = new JTextField(15);
    private JButton addButton = new JButton("Add");

    private ContactDatabase contactDatabase;
    private MainFrame mainFrame;

    public InsertFrame(ContactDatabase contactDatabase, MainFrame mainFrame) {
        this.contactDatabase = contactDatabase;
        this.mainFrame = mainFrame;

        setTitle("Insert Contact");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Number:"));
        panel.add(numberField);
        panel.add(addButton);

        addButton.addActionListener(this);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to add this contact?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                String name = nameField.getText();
                String number = numberField.getText();

                contactDatabase.insertContact(name, number);
                dispose();

                JOptionPane.showMessageDialog(mainFrame, "Contact created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
