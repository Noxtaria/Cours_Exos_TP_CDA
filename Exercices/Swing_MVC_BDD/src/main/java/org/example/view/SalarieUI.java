package org.example.view;

import org.example.controller.SalarieController;
import org.example.dao.SalarieDAO;
import org.example.model.Departement;
import org.example.model.Role;
import org.example.model.Salarie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SalarieUI extends JFrame implements ActionListener {
    private SalarieController salarieController;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField salaryField;
    private JComboBox<Departement> departmentComboBox;
    private JComboBox<Role> roleComboBox;
    private JList<String> salarieList;

    private JButton createButton;

    public SalarieUI() {
        super("Salarie Management");

        salarieController = new SalarieController(this, new SalarieDAO());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize UI components
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        salaryField = new JTextField(20);
        departmentComboBox = new JComboBox<>();
        roleComboBox = new JComboBox<>();
        salarieList = new JList<>();

        createButton = new JButton("Create");
        createButton.addActionListener(this);
        add(createButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create")) {
            salarieController.createSalarie();
        }
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public double getSalary() {
        return Double.parseDouble(salaryField.getText());
    }

    public Departement getSelectedDepartment() {
        return (Departement) departmentComboBox.getSelectedItem();
    }

    public Role getSelectedRole() {
        return (Role) roleComboBox.getSelectedItem();
    }

    public void refreshSalarieList(List<Salarie> salarieNames) {
        String[] namesArray = new String[salarieNames.size()];
        for (int i = 0; i < salarieNames.size(); i++) {
            namesArray[i] = salarieNames.get(i).getFirstName() + " " + salarieNames.get(i).getLastName();
        }
        salarieList.setListData(namesArray);
    }

    public void addCreateSalarieListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }
}
