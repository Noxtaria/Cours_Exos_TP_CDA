package org.example;

import org.example.layout.Formulaire;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Formulaire());
    }
}