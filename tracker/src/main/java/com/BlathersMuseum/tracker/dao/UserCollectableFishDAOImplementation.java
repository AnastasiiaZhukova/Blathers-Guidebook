package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.UserCollectableFish;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserCollectableFishDAOImplementation implements UserCollectableFishDAO{

    private EntityManager entityManager;

    @Autowired
    public UserCollectableFishDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //getting the list of usre collectables
    @Override
    @Transactional
    public List<UserCollectableFish> getUserCollectableList(int userId) {
        return entityManager.createQuery("SELECT ucf FROM UserCollectableFish ucf WHERE ucf.user.id = :userId", UserCollectableFish.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    //saving user collectable
    @Override
    @Transactional
    public void saveUserCollectable(UserCollectableFish userCollectableFish) {
        entityManager.merge(userCollectableFish);
    }

    //get by id
    @Override
    @Transactional
    public UserCollectableFish getUserCollectable(int userId, int collectableId) {
        return entityManager.createQuery("SELECT ucf FROM UserCollectableFish ucf WHERE ucf.user.id = :userId AND ucf.collectableFish.collectableId = :collectableId", UserCollectableFish.class)
                .setParameter("userId", userId)
                .setParameter("collectableId", collectableId)
                .getSingleResult();
    }

    //getting the number of collectables
    @Override
    @Transactional
    public int getTotalFishCollectables() {
        Long totalCollectables = (Long) entityManager.createQuery("SELECT COUNT(c) FROM CollectableFish c").getSingleResult();
        return totalCollectables.intValue();
    }

    //getting the number of collected collectables
    @Override
    @Transactional
    public int getCollectedFish(int userId) {
        Long collectedCollectables = (Long) entityManager.createQuery("SELECT COUNT(ucf) FROM UserCollectableFish ucf WHERE ucf.user.id = :userId AND ucf.isCollected = true")
                .setParameter("userId", userId)
                .getSingleResult();
        return collectedCollectables.intValue();
    }

}
