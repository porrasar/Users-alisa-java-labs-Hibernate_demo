package com.perscholas.model_OneToMany_UniDirectional;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

//    package com.perscholas.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;




@Entity
@Table
public class Department implements Serializable {

    //-------------------------------------------variables------------------------------------------
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int did;
    private String dname;
    @OneToMany(targetEntity = Teacher.class, cascade = {CascadeType.ALL})
    private List teacherList;

    //-------------------------------------------constructor------------------------------------------
    public Department(int did, String dname) {
        super();
        this.did = did;
        this.dname = dname;
    }

    public Department() {
    }


    //-------------------------------------------getter and setter -----------------------------------------
    public List getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List teacherList) {
        this.teacherList = teacherList;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}

