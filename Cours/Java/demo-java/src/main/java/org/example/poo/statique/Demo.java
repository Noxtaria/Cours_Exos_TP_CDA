package org.example.poo.statique;

public class Demo {


    public static void demo(){


        User user = new User();
        System.out.println("user id " + user.getId());
        User user1 = new User();
        System.out.println("user1 id " + user1.getId());
        User user2 = new User();
        System.out.println("user2 id " + user2.getId());
        Employee employee = new Employee();
        System.out.println("employe id " + employee.getId());



    }


}
