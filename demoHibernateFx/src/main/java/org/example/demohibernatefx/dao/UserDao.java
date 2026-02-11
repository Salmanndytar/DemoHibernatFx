package org.example.demohibernatefx.dao;


import org.example.demohibernatefx.model.User;
import org.example.demohibernatefx.utils.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao {
    Session session;
    Transaction transaction;

    public void addUser(User user) {
        session = HibernateConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }
    public void ubdateUser(User user) {
        session = HibernateConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }
    public User getUserByName(String name) {
        session = HibernateConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        User u = null;
      try {
          u = session.createQuery("FROM User WHERE nom = :name", User.class)
                  .setParameter("name", name.trim())
                  .uniqueResult();
      } catch (RuntimeException e) {
          System.out.println("User "+name+" not found");
      }
        session.close();
      return u;
    }
    public User checkUser(String name, String password) {
        session = HibernateConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        User u = null;
      try {
          u = session.createQuery(" FROM User WHERE (nom = :name and password = :pass)", User.class)
                  .setParameter("name", name.trim())
                  .setParameter("pass", password.trim())
                  .uniqueResult();
      } catch (RuntimeException e) {
          System.out.println("User "+name+" not found");
      }
        session.close();
      return u;
    }
    public List<User> getAllUser() {
        session = HibernateConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();

      List<User> list=  session.createQuery("from User",User.class).list();
        session.close();
        return list;
    }
}
