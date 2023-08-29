package org.example.layout;

import lombok.Data;
import org.example.dao.EmployeeDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

@Data
public class TablePanel {
    private JPanel tablePanel;
    private EmployeeDAO employeeDAO;
    private FormPanel formPanel;
    private ButtonPanel buttonPanel;
    private JTable table;
    private List<String> listQualification;
    private static String[] columnNames = {
            "EmployeeId",
            "Name",
            "Gender",
            "Age",
            "BloodGroup",
            "ContactNo",
            "Qualification",
            "Date",
            "Address",
            "EmplImg"
    };

    private DefaultTableModel dtm = new DefaultTableModel(null, columnNames) {
        @Override
        public Class<?> getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }
    };


}
