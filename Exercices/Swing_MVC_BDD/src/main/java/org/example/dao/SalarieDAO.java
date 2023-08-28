package org.example.dao;

import org.example.model.Departement;
import org.example.model.Role;
import org.example.model.Salarie;
import org.example.utils.ConnexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalarieDAO {
    private Connection connection;

    public SalarieDAO() {
        connection = ConnexionDB.getConnection();
    }

    public void create(Salarie salarie) {
        String insertQuery = "INSERT INTO employees (first_name, last_name, salary, department_id, role_id) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, salarie.getFirstName());
            preparedStatement.setString(2, salarie.getLastName());
            preparedStatement.setDouble(3, salarie.getSalary());
            preparedStatement.setInt(4, salarie.getDepartment().getId());
            preparedStatement.setInt(5, salarie.getRole().ordinal());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Salarie> getAllSalaries() {
        List<Salarie> salaries = new ArrayList<>();
        String selectQuery = "SELECT * FROM employees";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                double salary = resultSet.getDouble("salary");
                int departmentId = resultSet.getInt("department_id");
                int roleId = resultSet.getInt("role_id");

                // Fetch department and role information from the database
                Departement department = fetchDepartmentById(departmentId);
                Role role = fetchRoleById(roleId);

                Salarie salarie = new Salarie(id, firstName, lastName, salary, department, role);
                salaries.add(salarie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salaries;
    }

    private Departement fetchDepartmentById(int departmentId) {
        String selectQuery = "SELECT * FROM departments WHERE id = ?";
        Departement department = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, departmentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                department = new Departement(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return department;
    }

    private Role fetchRoleById(int roleId) {
        String selectQuery = "SELECT * FROM roles WHERE id = ?";
        Role role = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, roleId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String roleName = resultSet.getString("role_name");
                role = convertToRoleEnum(roleName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

    private Role convertToRoleEnum(String roleName) {
        if ("MANAGER".equals(roleName)) {
            return Role.MANAGER;
        } else if ("EMPLOYEE".equals(roleName)) {
            return Role.EMPLOYEE;
        }
        return null;
    }
}
