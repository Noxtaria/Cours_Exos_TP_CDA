package org.example.view;

import org.example.controller.DepartementController;
import org.example.dao.DepartementDAO;
import org.example.model.Departement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class DepartementUI extends JFrame {
    private DepartementController departementController;
    private JTextField departementNameField;
    private JList<Departement> departementList;

    private JButton createButton;

    public DepartementUI(DepartementController departementController, DepartementDAO departementDAO) {
        super("Departement Management");

        this.departementController = departementController;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize UI components
        JLabel welcomeLabel = new JLabel("Bienvenue dans la gestion des départements !");
        add(welcomeLabel);

        departementNameField = new JTextField(20);
        add(departementNameField);

        createButton = new JButton("Créer Département");
        createButton.addActionListener(e -> departementController.createDepartement());
        add(createButton);

        departementList = new JList<>();
        JScrollPane listScrollPane = new JScrollPane(departementList);
        listScrollPane.setPreferredSize(new Dimension(300, 150));
        add(listScrollPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public DepartementUI() {

    }

    public String getDepartementName() {
        return departementNameField.getText();
    }

    public void refreshDepartementList(List<Departement> departements) {
        departementList.setListData(departements.toArray(new Departement[0]));
    }

    public void addCreateDepartementListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }
}
