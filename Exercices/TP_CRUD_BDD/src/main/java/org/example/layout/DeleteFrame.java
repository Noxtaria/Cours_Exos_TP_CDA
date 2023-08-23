package org.example.layout;

import org.example.ContactDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteFrame extends JFrame implements ActionListener {
    private JTextField idField = new JTextField(5);
    private JButton deleteButton = new JButton("Delete");

    private ContactDatabase contactDatabase;
    private MainFrame mainFrame;

    public DeleteFrame(ContactDatabase contactDatabase, MainFrame mainFrame) {
        this.contactDatabase = contactDatabase;
        this.mainFrame = mainFrame;

        setTitle("Delete Contact");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(deleteButton);

        deleteButton.addActionListener(this);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this contact?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(idField.getText());

                contactDatabase.deleteContact(id);
                mainFrame.refreshContacts();
                dispose();

                JOptionPane.showMessageDialog(mainFrame, "Contact deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}