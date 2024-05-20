package com.BlathersMuseum.tracker.service;

import com.BlathersMuseum.tracker.dao.UserCollectableFishDAO;
import com.BlathersMuseum.tracker.dao.UserCollectableSeaCreatureDAO;
import com.BlathersMuseum.tracker.dao.UserCollectableBugDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// servise for calculation collection progress for each user individually
@Service
public class CollectionService {

    @Autowired
    private UserCollectableFishDAO userCollectableFishDAO;

    @Autowired
    private UserCollectableSeaCreatureDAO userCollectableSeaCreatureDAO;

    @Autowired
    private UserCollectableBugDAO userCollectableBugDAO;

    // total collection %
    public int calculateTotalCollectionPercentage(int userId) {
        int fishPercentage = calculateFishCollectionPercentage(userId);
        int seaCreaturePercentage = calculateSeaCreatureCollectionPercentage(userId);
        int bugPercentage = calculateBugCollectionPercentage(userId);

        // average of 3 percentages
        return (fishPercentage + seaCreaturePercentage + bugPercentage) / 3;
    }

    //collection percentage for all tree types of collectables
    public int calculateFishCollectionPercentage(int userId) {
        return userCollectableFishDAO.getCollectedFish(userId) * 100 / userCollectableFishDAO.getTotalFishCollectables();
    }

    public int calculateSeaCreatureCollectionPercentage(int userId) {
        return userCollectableSeaCreatureDAO.getCollectedSeaCreature(userId) * 100 / userCollectableSeaCreatureDAO.getTotalSeaCreatureCollectables();
    }

    public int calculateBugCollectionPercentage(int userId) {
        return userCollectableBugDAO.getCollectedBug(userId) * 100 / userCollectableBugDAO.getTotalBugCollectables();
    }
}