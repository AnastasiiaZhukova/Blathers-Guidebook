package com.BlathersMuseum.tracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user_collectable_fish")
public class UserCollectableFish {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_collectable_fish_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="collectable_id", nullable=false)
    private CollectableFish collectableFish;

    @Column(name="is_collected")
    private Boolean isCollected;

    //constructors
    public UserCollectableFish() {

    }

    public UserCollectableFish(User user, CollectableFish collectableFish, Boolean isCollected) {
        this.user = user;
        this.collectableFish = collectableFish;
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

    public CollectableFish getCollectableFish() {
        return collectableFish;
    }

    public void setCollectableFish(CollectableFish collectableFish) {
        this.collectableFish = collectableFish;
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
        return "UserCollectableFish{" +
                "id=" + id +
                ", user=" + user +
                ", collectableFish=" + collectableFish +
                ", isCollected=" + isCollected +
                '}';
    }
}
