package org.example.layout;

import org.example.entity.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Formulaire extends JFrame implements ActionListener {

    private JTextField nameField;
    private JTextField emailField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderButtonGroup;
    private ArrayList<Person> peopleList;

    public Formulaire() {
        setTitle("Formulaire d'ajout");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        peopleList = new ArrayList<>();

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Nom:");
        nameField = new JTextField(20);

        gbc.gridy = 1;
        mainPanel.add(nameLabel, gbc);

        gbc.gridy = 2;
        mainPanel.add(nameField, gbc);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        gbc.gridy = 3;
        mainPanel.add(emailLabel, gbc);

        gbc.gridy = 4;
        mainPanel.add(emailField, gbc);

        JLabel genderLabel = new JLabel("Genre:");
        maleRadioButton = new JRadioButton("Homme");
        femaleRadioButton = new JRadioButton("Femme");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);

        gbc.gridy = 5;
        mainPanel.add(genderLabel, gbc);

        gbc.gridy = 6;
        mainPanel.add(genderPanel, gbc);

        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(this);

        gbc.gridy = 7;
        gbc.gridwidth = 2;
        mainPanel.add(addButton, gbc);

        add(mainPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
