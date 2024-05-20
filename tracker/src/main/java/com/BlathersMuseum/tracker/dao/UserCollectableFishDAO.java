package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.UserCollectableFish;
import java.util.List;

public interface UserCollectableFishDAO {

    List<UserCollectableFish> getUserCollectableList(int userId);
    void saveUserCollectable(UserCollectableFish userCollectableFish);
    UserCollectableFish getUserCollectable(int userId, int collectableId);
    int getTotalFishCollectables();
    int getCollectedFish(int userId);
}
