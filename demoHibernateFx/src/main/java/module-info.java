module org.example.demohibernatefx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.hibernate.orm.core;
    requires java.logging;
    requires jakarta.persistence;
    requires java.sql;

    requires java.naming;

    opens org.example.demohibernatefx to javafx.fxml;
    exports org.example.demohibernatefx;

    opens org.example.demohibernatefx.model to org.hibernate.orm.core;
    exports org.example.demohibernatefx.model;
    exports org.example.demohibernatefx.controller;
    opens org.example.demohibernatefx.controller to javafx.fxml;

}