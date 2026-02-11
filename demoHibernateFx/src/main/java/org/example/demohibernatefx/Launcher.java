package org.example.demohibernatefx;

import javafx.application.Application;
import org.example.demohibernatefx.controller.MainController;
import org.example.demohibernatefx.dao.RoleDao;
import org.example.demohibernatefx.dao.UserDao;
import org.example.demohibernatefx.model.Role;
import org.example.demohibernatefx.model.User;

public class Launcher {
    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//        RoleDao roleDao = new RoleDao();
//        User user = new User();
//
//       User u = userDao.getUserByName("Blad");
//       Role r = roleDao.getRoleById(1);
//       Role r2 = roleDao.getRoleById(2);
//
//       u.getRoles().add(r);
//       u.getRoles().add(r2);
//       userDao.ubdateUser(u);

       // System.out.println(r.getNom()+" "+u.getRoles().size());

        Application.launch(MainController.class, args);
    }
}
