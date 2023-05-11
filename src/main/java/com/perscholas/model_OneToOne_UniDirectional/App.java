package com.perscholas.model_OneToOne_UniDirectional;


//package com.perscholas.model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//----------------ONE-TO-ONE UNI-DIRECTIONAL-------------------------------------------------------
/*
This is and example of one-to-one uni-directional.
meaning there is one person for one address and i am only allowing the
user to access data uni-directional
which means from one entity class (i.e person) only will be able to access data,
 NOT ABLE to access from the other way (address).
 there is only one annotation used in the first entitiy in the 1:1 ratio (person).

- person id, that list the one address attached to that person

What makes it uni-directional is:
- only one entity class (Person) has the annotation
  @OneToOne over the field of the opposite entity class (Address).
  This entity class with the @@OneToOne annotation is the first 1 of the
  1:1 ratio

- the other entity class (address) does not have any annotation.

  ex.
  @OneToOne(cascade = CascadeType.ALL)
        private Address address;


  AND the getter and setters for that opposite foreign key field (address) is in the
   opposite entity (person)...

  ex.

   public Address getAddress() {
            return address;
        }
        public void setAddress(Address address) {
            this.address = address;
        }

    NO getter or setters in the opposite entity (adress).


The result is that it creates 2 tables:
- person (with a foreign key for address id)
- address


*/
//------------------------------------------------------------------

    public class App
    {
        public static void main( String[] args )
        {
            System.out.println("Maven + Hibernate + SQL One to One Mapping Annotations");
            SessionFactory factory = new
                    Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();

            Address a1 = new Address();
            a1.setCity("nyc");
            a1.setState("NY");
            a1.setStreet("27th street");
            a1.setZipcode(11103);

            Address a2 = new Address();
            a2.setCity("Bufflo");
            a2.setState("NY");
            a2.setStreet("28th street");
            a2.setZipcode(15803);

            Person p1 = new Person();
            p1.setAge(25);
            p1.setEmail("e.jon@email.com");
            p1.setName("elbert Adam");
            p1.setAddress(a1);

            Person p2 = new Person();
            p2.setAge(45);
            p2.setEmail("ch.fink@email.com");
            p2.setName("Christ fink");
            p2.setAddress(a2);

            session.save(p1);
            session.save(p2);
            session.save(a1);
            session.save(a2);

            t.commit();
        }
    }

