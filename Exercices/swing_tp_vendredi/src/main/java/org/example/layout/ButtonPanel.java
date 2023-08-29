package org.example.layout;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.beans.introspect.ClassInfo.clear;

public class ButtonPanel {
    private JPanel buttonPanel;
    private FormPanel formPanel;
    private EmployeeDAO employeeDAO;
    private TablePanel tablePanel;

    private JButton newButton;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton printButton;

    public ButtonPanel(FormPanel formPanel) {
        this.formPanel = formPanel;
        employeeDAO = new EmployeeDAO();
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new LineBorder(Color.BLACK));
        buttonPanel.setPreferredSize(new Dimension(200, 50));
        buttonPanel.setMaximumSize(new Dimension(500, 50));

        JLabel searchLabel = new JLabel("Search : ");
        buttonPanel.add(searchLabel);

        JTextField searchTextField = new JTextField(15);
        buttonPanel.add(searchLabel);

        newButton = new JButton("New");
        addButton = new JButton("Save");
        addButton.setEnabled(false);
        updateButton = new JButton("Update");
        updateButton.setEnabled(false);
        deleteButton = new JButton("Delete");
        deleteButton.setEnabled(false);
        clearButton = new JButton("Clear");
        printButton = new JButton("Print");

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newButton.setEnabled(false);
                addButton.setEnabled(true);
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
                clearButton.setEnabled(true);
                formPanel.setIdTextFieldStatus(false);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gender;
                if (formPanel.getMaleRadioButton().isSelected()){
                    gender = "MALE";
                } else {
                    gender = "FEMALE";
                }
                Employee employee = new Employee(
                        formPanel.getNameTextField().getText(),
                        gender,
                        Integer.parseInt(formPanel.getAgeTextField().getText()),
                        formPanel.getBloodGroupTextField().getText(),
                        formPanel.getContactNoTextField().getText(),
                        formPanel.getQualificationComboBox().getText(),
                        formPanel.getChooser().getDate,
                        formPanel.getAddressTextArea().getText(),
                        formPanel.getImagePathTextField().getText()
                );

                employeeDAO.add(employee);
                clear();
                tablePanel.tableRefresh();
                JOptionPane.showMessageDialog(buttonPanel, "Employee Add");
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
