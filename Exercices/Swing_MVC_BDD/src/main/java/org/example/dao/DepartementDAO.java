package org.example.dao;

import org.example.model.Departement;
import org.example.utils.ConnexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartementDAO {
    private Connection connection;

    public DepartementDAO() {
        connection = ConnexionDB.getConnection();
    }

    public void create(Departement departement) {
        String insertQuery = "INSERT INTO departments (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, departement.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Departement> getAllDepartements() {
        List<Departement> departements = new ArrayList<>();
        String selectQuery = "SELECT * FROM departments";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                departements.add(new Departement(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departements;
    }
}
