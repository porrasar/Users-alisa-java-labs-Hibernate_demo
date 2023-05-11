package com.test.hib.service;

import com.test.hib.model.User;
import com.test.hib.persistence.UserDao;
import com.test.hib.persistence.UserDaoHibernateImpl;

import java.util.Locale;

// THIS (MYUSERSERVICE,USERDAO,USERDAOHIBERNATEIMP, AND USER IS A
// REPRESENTATION OF DAO-FICATION OF THE HIBERNATE EXAMPLE
public class MyUserService
{
    public static void main(String[] args)
    {
        UserDao userDao = new UserDaoHibernateImpl();

        //create a new user
        User user = new User("alisa porras",
                  "alisa.porr@yahoo.com",
                   "password",
                    10,
                    100.00,"boston");

        int userId = userDao.createUser(user);
        System.out.println("returned useriId  " + userId);


        //find a user
        User user2 = userDao.findUser(userId);
        System.out.println(user2);
    }
}
