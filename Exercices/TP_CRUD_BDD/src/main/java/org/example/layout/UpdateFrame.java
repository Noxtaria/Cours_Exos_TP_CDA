package org.example.layout;

import org.example.ContactDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateFrame extends JFrame implements ActionListener {
    private JTextField idField = new JTextField(5);
    private JTextField nameField = new JTextField(15);
    private JTextField numberField = new JTextField(15);
    private JButton updateButton = new JButton("Update");

    private ContactDatabase contactDatabase;
    private MainFrame mainFrame;

    public UpdateFrame(ContactDatabase contactDatabase, MainFrame mainFrame) {
        this.contactDatabase = contactDatabase;
        this.mainFrame = mainFrame;

        setTitle("Update Contact");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("New Name:"));
        panel.add(nameField);
        panel.add(new JLabel("New Number:"));
        panel.add(numberField);
        panel.add(updateButton);

        updateButton.addActionListener(this);

        add(panel);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to update this contact?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(idField.getText());
                String newName = nameField.getText();
                String newNumber = numberField.getText();

                contactDatabase.updateContact((long) id, newName, newNumber);
                dispose();

                JOptionPane.showMessageDialog(mainFrame, "Contact updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}

