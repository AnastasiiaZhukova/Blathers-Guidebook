package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.UserCollectableSeaCreature;
import java.util.List;

public interface UserCollectableSeaCreatureDAO {

    List<UserCollectableSeaCreature> getUserCollectableList(int userId);
    void saveUserCollectable(UserCollectableSeaCreature userCollectableSeaCreature);
    UserCollectableSeaCreature getUserCollectable(int userId, int collectableId);
    int getTotalSeaCreatureCollectables();
    int getCollectedSeaCreature(int userId);
}
