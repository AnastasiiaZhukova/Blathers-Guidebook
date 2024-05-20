package com.BlathersMuseum.tracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users_roles")
public class UsersRoles {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private int userRoleId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    //constructors
    public UsersRoles() {
    }

    public UsersRoles(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    //getters and setters
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //to str
    @Override
    public String toString() {
        return "UsersRoles{" +
                "userRoleId=" + userRoleId +
                ", user=" + user +
                ", role=" + role +
                '}';
    }
}
