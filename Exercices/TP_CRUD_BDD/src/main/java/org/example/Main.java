package org.example;

import org.example.layout.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContactDatabase contactDatabase = new ContactDatabase();
            new MainFrame(contactDatabase);
        });
    }
}
