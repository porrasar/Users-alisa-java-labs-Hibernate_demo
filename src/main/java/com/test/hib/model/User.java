package com.test.hib.model;

import javax.persistence.*;

@Entity                // this means i want a corresponding table in the database
//@Table(name="USER")  //this is optional, unless i want to use a different table name from class name
public class User
{


        @Id              // required for entity class. declares that the field with 'id' is the id field
        @GeneratedValue(strategy = GenerationType.IDENTITY)  //asking to generate primary key automatically
        private Integer id;
        private String fullname;
        private String email;
        private String password;
        private int age;
        private double salary;
        private String city;

        public User(String fullname, String email, String password,
                    int age, double salary, String city)
        {
            //this.id = id;   // this is not needed b/c of the @Generated statement
            this.fullname = fullname;
            this.email = email;
            this.password = password;
            this.age = age;
            this.salary = salary;
            this.city = city;
        }

        public User() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                '}';
    }


}