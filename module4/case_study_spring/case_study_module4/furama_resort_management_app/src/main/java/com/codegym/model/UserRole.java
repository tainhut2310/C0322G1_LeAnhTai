package com.codegym.model;

import javax.persistence.*;

@Entity
@Table("user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public UserRole() {
    }

    public UserRole(Role role, User user) {
        this.role = role;
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
