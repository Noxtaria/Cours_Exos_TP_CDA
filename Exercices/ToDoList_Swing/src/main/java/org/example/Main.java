package org.example;

import org.example.layout.ToDoList;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoList());
    }
}