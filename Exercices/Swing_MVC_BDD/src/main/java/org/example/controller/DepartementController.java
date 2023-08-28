package org.example.controller;


import org.example.dao.DepartementDAO;
import org.example.model.Departement;
import org.example.view.DepartementUI;

public class DepartementController {
    private DepartementUI departementUI;
    private DepartementDAO departementDAO;

    public DepartementController(DepartementUI departementUI, DepartementDAO departementDAO) {
        this.departementUI = departementUI;
        this.departementDAO = departementDAO;

        this.departementUI.addCreateDepartementListener(event -> createDepartement());
    }

    private void createDepartement() {
        String name = departementUI.getDepartementName();
        Departement departement = new Departement(name);
        departementDAO.create(departement);
        departementUI.refreshDepartementList(departementDAO.getAllDepartements());
    }
}