package tn.formalab.ecommerce.models;

import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "firstname", nullable = false)
    public String firstname;

    @Column(name = "lastname", nullable = false)
    public String lastname;

    @Column(name = "email", unique = true, nullable = false)
    public String email;

    @Column(name = "password", nullable = false)
    public String password;

    @Column(name = "role")
    public String role = "client";

    @Column(name = "accountState")
    public Boolean accountState = true;
}