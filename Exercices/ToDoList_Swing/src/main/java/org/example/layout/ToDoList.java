package org.example.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoList extends JFrame implements ActionListener {

    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;
    private JTextField taskField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton completeButton;

    public ToDoList() {
        setTitle("ToDoList App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);
        JScrollPane scrollPane = new JScrollPane(todoList);

        ImageIcon addIcon = new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Dossier Formation\\Cours_Exos_TP_CDA\\Exercices\\ToDoList_Swing\\src\\main\\resources\\add+.png");
        ImageIcon deleteIcon = new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Dossier Formation\\Cours_Exos_TP_CDA\\Exercices\\ToDoList_Swing\\src\\main\\resources\\trash+.png");
        ImageIcon completeIcon = new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Dossier Formation\\Cours_Exos_TP_CDA\\Exercices\\ToDoList_Swing\\src\\main\\resources\\complete+.png");

        taskField = new JTextField(20);
        addButton = new JButton("Add", addIcon);
        deleteButton = new JButton("Delete", deleteIcon);
        completeButton = new JButton("Complete", completeIcon);


        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        completeButton.addActionListener(this);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(taskField, BorderLayout.NORTH);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(completeButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String newTask = taskField.getText();
            if (!newTask.isEmpty()) {
                todoListModel.addElement(newTask);
                taskField.setText("");
            }
        } else if (e.getSource() == deleteButton) {
            int selectedIndex = todoList.getSelectedIndex();
            if (selectedIndex != -1) {
                todoListModel.remove(selectedIndex);
            }
        } else if (e.getSource() == completeButton) {
            int selectedIndex = todoList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedTask = todoListModel.getElementAt(selectedIndex);
                todoListModel.setElementAt("<html><strike>" + selectedTask + "</strike></html>", selectedIndex);
            }
        }
    }
}

