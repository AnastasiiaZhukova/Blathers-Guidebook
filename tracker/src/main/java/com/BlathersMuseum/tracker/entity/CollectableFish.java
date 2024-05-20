package com.BlathersMuseum.tracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name="collectable_fish")
public class CollectableFish {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="collectable_id")
    private int collectableId;

    @Column(name="collectable_name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="location")
    private String location;

    @Column(name="time")
    private String time;

    @Column(name="months")
    private String months;

    @Column(name="is_collected")
    private Boolean isCollected;

    //constructors
    public CollectableFish(){

    }

    public CollectableFish(String name, String type, String location, String time, String months, Boolean isCollected) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.time = time;
        this.months = months;
        this.isCollected = isCollected;
    }

    //getters and setters
    public int getCollectableId() {
        return collectableId;
    }

    public void setCollectableId(int collectableId) {
        this.collectableId = collectableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public Boolean getCollected() {
        return isCollected;
    }

    public void setCollected(Boolean collected) {
        isCollected = collected;
    }

    //toString
    @Override
    public String toString() {
        return "CollectableFish{" +
                "collectableId=" + collectableId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", time='" + time + '\'' +
                ", months='" + months + '\'' +
                ", isCollected=" + isCollected +
                '}';
    }
}
