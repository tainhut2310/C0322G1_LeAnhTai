package com.codegym.model;

import javax.persistence.*;

@Entity
@Table("role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}
