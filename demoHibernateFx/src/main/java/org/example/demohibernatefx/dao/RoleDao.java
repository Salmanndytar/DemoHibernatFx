package org.example.demohibernatefx.dao;

import org.example.demohibernatefx.model.Role;
import org.example.demohibernatefx.model.User;
import org.example.demohibernatefx.utils.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDao {
    Session session ;
    Transaction transaction;
    public Role getRoleById(Integer id) {
        session = HibernateConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();

       Role r = session.find(Role.class, id);
        session.close();
        return r;
    }
    public List<Role> getAullRol() {
        session = HibernateConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        List<Role>  r = session.createQuery("from Role ",Role.class).list();
        session.close();
        return r;
    }
}
