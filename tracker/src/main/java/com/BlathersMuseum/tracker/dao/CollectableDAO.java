package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.Collectable;
import java.util.List;

public interface CollectableDAO {

    List<Collectable> getCollectables();
    Collectable getCollectableByName(String name);
    void updateCollectable(Collectable collectable);
}
