package org.example.model;

public class Salarie {
    private int id;
    private String firstName;
    private String lastName;
    private Role role;
    private double salary;
    private Departement department;

    public Salarie() {
    }

    public Salarie(int id, String firstName, String lastName, Role role, double salary, Departement department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
        this.department = department;
    }

    public Salarie(String firstName, String lastName, double salary, Departement department, Role role) {
    }

    public Salarie(int id, String firstName, String lastName, double salary, Departement department, Role role) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Departement getDepartment() {
        return department;
    }

    public void setDepartment(Departement department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Salarie{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}