package org.example.demohibernatefx.model;
import org.example.demohibernatefx.model.Role;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 25)
    private String nom;

    @Column(length = 40)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "User-Role",
    joinColumns = @JoinColumn(name = "id-User"),
            inverseJoinColumns = @JoinColumn(name = "id-Role")
    )
    List<Role> roles;


    public User() {
    }

    public User(Integer id, String nom, String password) {
        this.id = id;
        this.nom = nom;
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  nom ;
    }
}
