package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.CollectableFish;
import java.util.List;

public interface CollectableFishDAO {
    List<CollectableFish> getCollectableList();
    CollectableFish getCollectableByName(String name);
    void updateCollectable(CollectableFish collectable);
}
