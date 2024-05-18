package com.BlathersMuseum.tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Data
@Table(name = "USERS")
public class Users {
    private int id;
    private String password;
    private String name;
}
