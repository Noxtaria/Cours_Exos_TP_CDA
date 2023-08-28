package org.example;

import org.example.dao.DepartementDAO;
import org.example.dao.SalarieDAO;
import org.example.controller.DepartementController;
import org.example.controller.SalarieController;
import org.example.view.DepartementUI;
import org.example.view.SalarieUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DepartementDAO departementDAO = new DepartementDAO();
            SalarieDAO salarieDAO = new SalarieDAO();

            DepartementUI departementUI = new DepartementUI();
            DepartementController departementController = new DepartementController(departementUI, departementDAO);
//            departementUI.setVisible(true);

            SalarieUI salarieUI = new SalarieUI();
            SalarieController salarieController = new SalarieController(salarieUI, salarieDAO);
            salarieUI.setVisible(true);
        });
    }
}
