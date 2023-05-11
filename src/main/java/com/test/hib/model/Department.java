package com.test.hib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

@Entity                // this means i want a corresponding table in the database
public class Department {

    //@Table(name="USER")  //this is optional, unless i want to use a different table name from class name
    @Id              // required, declares that the field this is above, is the primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //asking to generate primary key automatically
     private int id;

    private String name;
    private String state;


    //----------------------------------------CONSTRUCTOR---------------------------------------------------------

    public Department() {
    }

    public Department(String name, String state)
    {
        //this.id = id;  // don't need this because it is being automatically generated with @GeneratedValue
        this.name = name;
        this.state = state;

    }

    //----------------------------------------GETTER/SETTER----------------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Department_ManyToOne{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

