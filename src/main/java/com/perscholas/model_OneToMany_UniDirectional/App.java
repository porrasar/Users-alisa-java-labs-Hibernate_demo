package com.perscholas.model_OneToMany_UniDirectional;

import java.util.ArrayList;
import java.util.List;


//    package com.perscholas.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//----------------ONE-TO-MANY UNI-DIRECTIONAL-------------------------------------------------------
/*
This is and example of one-to-many uni-directional.
meaning there is one department for many teachers and i am only allowing the
user to access data uni-directional
which means from one entity class (i.e department) only, NOT ABLE to access
from the other way (teacher). there is only one annotation used, and it's in the 1 of the
1:m ratio (department)
- department id, that list all teachers attached to that department

What makes it uni-directional is:
- only one entity class (Department) has the annotation
  @OneToMany over the field of the opposite entity class (Teacher).
  This entity class with the @OneToMany annotation is the 1 of the
  1:m ratio

- the other entity class (teacher) does not have any annotation.

  ex.
  @OneToMany(targetEntity = Teacher.class, cascade = {CascadeType.ALL})
    private List teacherList;


  AND the getter and setters for that opposite fields  (teacher array) are in the
   opposite entity (department)...

  ex.

    public List getTeacherList()
    {
        return teacherList;
    }

    public void setTeacherList(List teacherList)
    {
        this.teacherList = teacherList;
    }

    NO getter or setters in the opposite entity (teacher).


The result is that it creates 3 tables:
- department
- teacher (with a foreign key for dept id)
- department_teacher

*/
//------------------------------------------------------------------

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new
                Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Teacher t1 = new Teacher();
        t1.setTeachername("Haseeb");
        t1.setSalary("100");

        Teacher t2 = new Teacher();
        t2.setTeachername("Jenny Finch");
        t2.setSalary("10000");

        Teacher t3 = new Teacher();
        t3.setTeachername("James");
        t3.setSalary("25000");

        Teacher t4 = new Teacher();
        t4.setTeachername("SID ROSE");
        t4.setSalary("3000");

        Teacher t5 = new Teacher();
        t5.setSalary("200");
        t5.setTeachername("Ali");

    //Add teacher entity object to the list
        List<Teacher> teachlist = new ArrayList();
        teachlist.add(t1);
        teachlist.add(t2);
        teachlist.add(t3);
        teachlist.add(t4);
        teachlist.add(t5);

        session.save(t1);
        session.save(t2);
        session.save(t3);
        session.save(t4);
        session.save(t5);

    //Create Department
        Department department = new Department();
        department.setDname("Development");
        department.setTeacherList(teachlist);

    //Store Department
        session.save(department);
        t.commit();
    }
}
