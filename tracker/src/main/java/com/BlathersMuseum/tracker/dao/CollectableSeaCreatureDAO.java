package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.CollectableSeaCreature;
import java.util.List;

public interface CollectableSeaCreatureDAO {
    List<CollectableSeaCreature> getCollectableList();
    CollectableSeaCreature getCollectableByName(String name);
    void updateCollectable(CollectableSeaCreature collectable);
}
