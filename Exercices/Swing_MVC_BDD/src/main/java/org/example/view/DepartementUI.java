package org.example.view;


import org.example.controller.DepartementController;
import org.example.dao.DepartementDAO;
import org.example.model.Departement;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class DepartementUI {
    private DepartementController departementController;
    private JFrame frame;
    private JTextField departementNameField;
    private JList<Departement> departementList;

    public DepartementUI() {
        frame = new JFrame("Departement Management");

        departementController = new DepartementController(this, new DepartementDAO());
    }

    public void addCreateDepartementListener(ActionListener listener) {
    }

    public String getDepartementName() {
        return departementNameField.getText();
    }

    public void refreshDepartementList(List<Departement> departements) {
        departementList.setListData(departements.toArray(new Departement[0]));
    }

}