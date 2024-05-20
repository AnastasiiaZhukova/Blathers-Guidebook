package com.BlathersMuseum.tracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name="applied_users")
public class AppliedUsers {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="applied_users_id")
    private int appliedUsersId;

    @Column(name="user_name")
    private String userName;

    //constructors
    public AppliedUsers() {
    }

    public AppliedUsers(String userName) {
        this.userName = userName;
    }

    //getters and setters
    public int getAppliedUsersId() {
        return appliedUsersId;
    }

    public void setAppliedUsersId(int appliedUsersId) {
        this.appliedUsersId = appliedUsersId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //to string
    @Override
    public String toString() {
        return "AppliedUsers{" +
                "appliedUsersId=" + appliedUsersId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
