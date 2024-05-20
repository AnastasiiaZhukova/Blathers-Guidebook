package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.UserCollectableBug;
import java.util.List;

public interface UserCollectableBugDAO {

    List<UserCollectableBug> getUserCollectableList(int userId);
    void saveUserCollectable(UserCollectableBug userCollectableBug);
    UserCollectableBug getUserCollectable(int userId, int collectableId);
    int getTotalBugCollectables();
    int getCollectedBug(int userId);
}
