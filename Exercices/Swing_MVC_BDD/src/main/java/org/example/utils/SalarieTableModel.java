package org.example.utils;

import javax.swing.table.AbstractTableModel;
import java.util.List;

import org.example.model.Salarie;

public class SalarieTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"ID", "First Name", "Last Name", "Salary", "Department", "Role"};
    private List<Salarie> salaries;

    public SalarieTableModel(List<Salarie> salaries) {
        this.salaries = salaries;
    }

    @Override
    public int getRowCount() {
        return salaries.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Salarie salarie = salaries.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return salarie.getId();
            case 1:
                return salarie.getFirstName();
            case 2:
                return salarie.getLastName();
            case 3:
                return salarie.getSalary();
            case 4:
                return salarie.getDepartment().getName();
            case 5:
                return salarie.getRole().toString();
            default:
                return null;
        }
    }
}