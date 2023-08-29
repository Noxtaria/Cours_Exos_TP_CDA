package org.example.model;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
@Data
public class Employee {
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String bloodGroup;
    private String contactNo;
    private String qualification;
    private Date date;
    private String address;
    private String employeeImg;

    public Employee() {
    }

    public Employee(Long id, String name, String gender, Integer age, String bloodGroup, String contactNo, String qualification, Date date, String address, String employeeImg) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.contactNo = contactNo;
        this.qualification = qualification;
        this.date = date;
        this.address = address;
        this.employeeImg = employeeImg;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmployeeImg(String employeeImg) {
        this.employeeImg = employeeImg;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", qualification='" + qualification + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", employeeImg='" + employeeImg + '\'' +
                '}';
    }
}
