package org.example.dao;

import org.example.model.Employee;
import org.example.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private Connection con;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public boolean add(Employee employee) {
        con = ConnectionUtil.getConnection();
        try {
            preparedStatement = con.prepareStatement("INSERT INTO employee(`name`,`gender`,`age`,`blood_group`,`contact_no`,`qualification`,`doj`,`address`,`employee_image`) VALUES(?,?,?,?,?,?,?,?,?) ");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getGender());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getBloodGroup());
            preparedStatement.setString(5, employee.getContactNo());
            preparedStatement.setString(6, employee.getQualification());
            preparedStatement.setDate(7, new Date(employee.getDate().getTime()));
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setString(9, employee.getEmployeeImg());
            int n = preparedStatement.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update (Employee employee){
        con = ConnectionUtil.getConnection();
        try {
            preparedStatement = con.prepareStatement("UPDATE employee SET name=?,gender=?,age=?,blood_group=?,contact_no=?,qualification=?,doj=?,address=?,employee_image=? where id = ?");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getGender());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getBloodGroup());
            preparedStatement.setString(5, employee.getContactNo());
            preparedStatement.setString(6, employee.getQualification());
            preparedStatement.setDate(7, new Date(employee.getDate().getTime()));
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setString(9, employee.getEmployeeImg());
            preparedStatement.setLong(10, employee.getId());
            int n = preparedStatement.executeUpdate();
            return n>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete (Long id){
        con = ConnectionUtil.getConnection();
        try {
            preparedStatement = con.prepareStatement("DELETE FROM employee WHERE id = ? ");
            preparedStatement.setLong(1, id);
            int n = preparedStatement.executeUpdate();
            return n > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Employee findById(Long id) {
        con = ConnectionUtil.getConnection();
        try {
            preparedStatement = con.prepareStatement("SELECT id,name,gender,age,blood_group,contact_no,qualification,doj,address,employee_image FROM employee where id = ? ");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return  new Employee(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        resultSet.getString("blood_group"),
                        resultSet.getString("contact_no"),
                        resultSet.getString("qualification"),
                        resultSet.getDate("doj"),
                        resultSet.getString("address"),
                        resultSet.getString("employee_image")
                );

            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Employee> findAll (){
        con = ConnectionUtil.getConnection();
        List<Employee> list = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement("SELECT id,name,gender,age,blood_group,contact_no,qualification,doj,address,employee_image FROM employee ");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(new Employee(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        resultSet.getString("blood_group"),
                        resultSet.getString("contact_no"),
                        resultSet.getString("qualification"),
                        resultSet.getDate("doj"),
                        resultSet.getString("address"),
                        resultSet.getString("employee_image")
                ));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
