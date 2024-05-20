package com.BlathersMuseum.tracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user_collectable_bug")
public class UserCollectableBug {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_collectable_bug_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="collectable_id", nullable=false)
    private CollectableBug collectableBug;

    @Column(name="is_collected")
    private Boolean isCollected;

    //constructors
    public UserCollectableBug() {

    }

    public UserCollectableBug(User user, CollectableBug collectableBug, Boolean isCollected) {
        this.user = user;
        this.collectableBug = collectableBug;
        this.isCollected = isCollected;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CollectableBug getCollectableBug() {
        return collectableBug;
    }

    public void setCollectableBug(CollectableBug collectableBug) {
        this.collectableBug = collectableBug;
    }

    public Boolean getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(Boolean collected) {
        isCollected = collected;
    }

    //to str
    @Override
    public String toString() {
        return "UserCollectableBug{" +
                "id=" + id +
                ", user=" + user +
                ", collectableBug=" + collectableBug +
                ", isCollected=" + isCollected +
                '}';
    }
}
