package org.example.demohibernatefx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import org.example.demohibernatefx.dao.RoleDao;
import org.example.demohibernatefx.dao.UserDao;
import org.example.demohibernatefx.model.Role;
import org.example.demohibernatefx.model.User;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RolToUserController implements Initializable {
    @FXML
    CheckBox idAdmCheck;
    @FXML
    CheckBox idManCheck;

    @FXML
    ComboBox<User> usersComb;

    RoleDao roleDao =  new RoleDao();
    UserDao userDao = new UserDao();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Role> r =roleDao.getAullRol();
        idAdmCheck.setText(r.get(0).getNom());
        idManCheck.setText(r.get(1).getNom());

        System.out.println(userDao.getAllUser().size());
        List<User> list = userDao.getAllUser();
        ObservableList<User> observableList = FXCollections.observableArrayList(list);
        usersComb.setItems(observableList);

    }
}
