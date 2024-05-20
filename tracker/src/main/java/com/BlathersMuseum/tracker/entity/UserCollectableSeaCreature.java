package com.BlathersMuseum.tracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user_collectable_sea_creature")
public class UserCollectableSeaCreature {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_collectable_sea_creature_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="collectable_id", nullable=false)
    private CollectableSeaCreature collectableSeaCreature;

    @Column(name="is_collected")
    private Boolean isCollected;


    //constructors
    public UserCollectableSeaCreature() {

    }

    public UserCollectableSeaCreature(User user, CollectableSeaCreature collectableSeaCreature, Boolean isCollected) {
        this.user = user;
        this.collectableSeaCreature = collectableSeaCreature;
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

    public CollectableSeaCreature getCollectableSeaCreature() {
        return collectableSeaCreature;
    }

    public void setCollectableSeaCreature(CollectableSeaCreature collectableSeaCreature) {
        this.collectableSeaCreature = collectableSeaCreature;
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
        return "UserCollectableSeaCreature{" +
                "id=" + id +
                ", user=" + user +
                ", collectableSeaCreature=" + collectableSeaCreature +
                ", isCollected=" + isCollected +
                '}';
    }
}
