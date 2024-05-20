package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.CollectableBug;

import java.util.List;

public interface CollectableBugDAO {
    List<CollectableBug> getCollectableList();
    CollectableBug getCollectableByName(String name);
    void updateCollectable(CollectableBug collectable);
}
