package org.example.controller;

import org.example.dao.SalarieDAO;
import org.example.model.Departement;
import org.example.model.Salarie;
import org.example.view.SalarieUI;


import org.example.model.Role;

import java.util.List;

public class SalarieController {
    private SalarieUI salarieUI;
    private SalarieDAO salarieDAO;

    public SalarieController(SalarieUI salarieUI, SalarieDAO salarieDAO) {
        this.salarieUI = salarieUI;
        this.salarieDAO = salarieDAO;

        this.salarieUI.addCreateSalarieListener(event -> createSalarie());

        salarieUI.setVisible(true);
    }

    public void createSalarie() {
        String firstName = salarieUI.getFirstName();
        String lastName = salarieUI.getLastName();
        double salary = salarieUI.getSalary();

        Departement department = salarieUI.getSelectedDepartment();
        Role role = salarieUI.getSelectedRole();

        Salarie salarie = new Salarie(firstName, lastName, salary, department, role);
        salarieDAO.create(salarie);

        List<Salarie> allSalaries = salarieDAO.getAllSalaries();
        salarieUI.refreshSalarieList(allSalaries);
    }
}