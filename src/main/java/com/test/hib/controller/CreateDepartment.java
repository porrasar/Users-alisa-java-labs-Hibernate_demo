package com.test.hib.controller;

import com.test.hib.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateDepartment {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        SessionFactory factory = new
                Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();


        Department departmentOne = new Department();
        departmentOne.setName("Home Department_ManyToOne");
        departmentOne.setState("34");


        Department departmentTwo = new Department();
         departmentTwo.setName("Kitchen Department_ManyToOne");
        departmentTwo.setState("24");


        Department departmentThree = new Department();
        departmentThree.setName("Living Room Department_ManyToOne");
        departmentThree.setState("51");


        /*========= We can pass value/data by using constructor =========*/
        Department departmentFour = new Department("Dining Department_ManyToOne","32");
        ;


        session.save(departmentOne);
        session.save(departmentTwo);
        session.save(departmentThree);
        session.save(departmentFour);


        t.commit();

        System.out.println("successfully saved");
        factory.close();
        session.close();
    }


}
