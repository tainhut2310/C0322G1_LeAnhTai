package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "appRoles")
    private Set<AppUser> appUsers;

    public AppRole() {
    }

    public AppRole(Long id, String name, Set<AppUser> appUsers) {
        this.id = id;
        this.name = name;
        this.appUsers = appUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(Set<AppUser> appUsers) {
        this.appUsers = appUsers;
    }
}
