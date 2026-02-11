package org.example.demohibernatefx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.demohibernatefx.dao.UserDao;
import org.example.demohibernatefx.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConnexionController implements Initializable {

    @FXML
    private TextField idNomTxt;
    @FXML
    private PasswordField idPasswordTxt;
    @FXML
    private Button idBtn;

    UserDao userDao ;
    User user;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idBtn.setDisable(true);
    }


    @FXML
    protected void valideAction() throws IOException {
       connexion();
       // System.out.println(idNomTxt.getText()+" "+ idPasswordTxt.getText());
    }
    void  addUser(){
        user = new User();
        userDao = new UserDao();
        user.setNom(idNomTxt.getText());
        user.setPassword(idPasswordTxt.getText());
        userDao.addUser(user);
        idNomTxt.clear();
        idPasswordTxt.clear();
    }
    void connexion() throws IOException {
        user = new User();
        userDao = new UserDao();
        user.setNom(idNomTxt.getText());
        user.setPassword(idPasswordTxt.getText());
        User u = userDao.checkUser(user.getNom(), user.getPassword());
        idNomTxt.clear();
        idPasswordTxt.clear();
        if (u!=null){
            System.out.println("ok");
            load();
        }
        else{
            System.out.println("erreur");
        }
    }
    @FXML
    void isName(MouseEvent event) {
        if (!idNomTxt.getText().isEmpty()&& !idPasswordTxt.getText().isEmpty())
            idBtn.setDisable(false);
        else
            idBtn.setDisable(true);
    }

    @FXML
    void isPassword(MouseEvent event) {
        if (!idNomTxt.getText().isEmpty()&& !idPasswordTxt.getText().isEmpty())
            idBtn.setDisable(false);
        else
            idBtn.setDisable(true);
    }
    void load() throws IOException {
        Stage currenttage = (Stage) idBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/org/example/demohibernatefx/rolToUser.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Role to User");
        stage.setResizable(false);
        stage.show();
        currenttage.close();

    }
}
