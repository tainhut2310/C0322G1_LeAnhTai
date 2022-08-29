package com.codegym.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table("user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userName;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<User> userList;
}
