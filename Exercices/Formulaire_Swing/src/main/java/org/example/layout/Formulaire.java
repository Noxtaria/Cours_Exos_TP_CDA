package org.example.layout;

import org.example.entity.Person;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
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

    private DefaultTableModel tableModel;
    private JTable dataTable;

    private JButton addButton;
    private JButton detailsButton;

    public Formulaire() {
        setTitle("Complex Two Panel Example");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TitledBorder formBorder = BorderFactory.createTitledBorder("Formulaire d'ajout");
        formBorder.setTitleFont(new Font("Arial", Font.PLAIN, 14));
        formBorder.setTitleColor(Color.BLACK);

        TitledBorder tableBorder = BorderFactory.createTitledBorder("Tableau des données");
        tableBorder.setTitleFont(new Font("Arial", Font.PLAIN, 14));
        tableBorder.setTitleColor(Color.BLACK);

        peopleList = new ArrayList<>();

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(formBorder);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Nom:");
        nameField = new JTextField(20);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(nameField, gbc);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(emailField, gbc);

        JLabel genderLabel = new JLabel("Genre:");
        maleRadioButton = new JRadioButton("Homme");
        femaleRadioButton = new JRadioButton("Femme");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        int horizontalSpace = 20;
        genderPanel.add(Box.createHorizontalStrut(horizontalSpace));

        genderPanel.add(maleRadioButton);

        genderPanel.add(Box.createHorizontalStrut(horizontalSpace));

        genderPanel.add(femaleRadioButton);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(genderPanel, gbc);

        addButton = new JButton("Ajouter");
        addButton.addActionListener(this);

        gbc.gridy = 7;
        gbc.gridwidth = 2;
        mainPanel.add(addButton, gbc);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nom");
        tableModel.addColumn("Email");
        tableModel.addColumn("Genre");

        dataTable = new JTable(tableModel);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(tableBorder);
        tablePanel.add(new JScrollPane(dataTable), BorderLayout.CENTER);

        detailsButton = new JButton("Détails");
        detailsButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(detailsButton);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(mainPanel, BorderLayout.NORTH);
        contentPane.add(tablePanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            if (clickedButton == addButton) {
                String name = nameField.getText();
                String email = emailField.getText();
                String gender = maleRadioButton.isSelected() ? "Homme" : "Femme";

                Person person = new Person(name, email, gender);
                peopleList.add(person);

                Object[] rowData = {name, email, gender};
                tableModel.addRow(rowData);

                nameField.setText("");
                emailField.setText("");
                genderButtonGroup.clearSelection();
            } else if (clickedButton == detailsButton) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow != -1) {
                    String name = (String) tableModel.getValueAt(selectedRow, 0);
                    String email = (String) tableModel.getValueAt(selectedRow, 1);
                    String gender = (String) tableModel.getValueAt(selectedRow, 2);
                    JOptionPane.showMessageDialog(this, "Détails:\nNom: " + name + "\nEmail: " + email + "\nGenre: " + gender);
                } else {
                    JOptionPane.showMessageDialog(this, "Sélectionnez une ligne dans le tableau.");
                }
            }
        }
    }


}
