package org.example.demohibernatefx.utils;

import org.example.demohibernatefx.model.Role;
import org.example.demohibernatefx.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.InputStream;
import java.util.logging.LogManager;

public class HibernateConfig {

 private static final SessionFactory sessionFactory;

 static {
  loggin();
  try {
   Configuration config = new Configuration();

   config.addAnnotatedClass(User.class);
    config.addAnnotatedClass(Role.class);

   sessionFactory = config.buildSessionFactory();

  } catch (Exception e) {
   throw new ExceptionInInitializerError(e);
  }
 }

 public static SessionFactory getSessionFactory() {
  System.out.println("session fec de propert est: " + sessionFactory);
  return sessionFactory;
 }
public static void loggin(){

   try (InputStream is =
                Thread.currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream("logging.properties")) {

    if (is != null) {
     LogManager.getLogManager().readConfiguration(is);
    }
   } catch (Exception e) {
    e.printStackTrace();
   }


 }
}

