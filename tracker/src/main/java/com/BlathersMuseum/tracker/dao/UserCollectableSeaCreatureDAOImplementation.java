package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.UserCollectableSeaCreature;
import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserCollectableSeaCreatureDAOImplementation implements UserCollectableSeaCreatureDAO{

    //eentity manager
    private EntityManager entityManager;

    @Autowired
    public UserCollectableSeaCreatureDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //get list of user collectables
    @Override
    @Transactional
    public List<UserCollectableSeaCreature> getUserCollectableList(int userId) {
        return entityManager.createQuery("SELECT ucf FROM UserCollectableSeaCreature ucf WHERE ucf.user.id = :userId", UserCollectableSeaCreature.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    //save
    @Override
    @Transactional
    public void saveUserCollectable(UserCollectableSeaCreature userCollectableSeaCreature) {
        entityManager.merge(userCollectableSeaCreature);
    }

    //getting by id
    @Override
    @Transactional
    public UserCollectableSeaCreature getUserCollectable(int userId, int collectableId) {
        return entityManager.createQuery("SELECT ucf FROM UserCollectableSeaCreature ucf WHERE ucf.user.id = :userId AND ucf.collectableSeaCreature.collectableId = :collectableId", UserCollectableSeaCreature.class)
                .setParameter("userId", userId)
                .setParameter("collectableId", collectableId)
                .getSingleResult();
    }

    //getting the number of collectables
    @Override
    @Transactional
    public int getTotalSeaCreatureCollectables() {
        //
        Long totalCollectables = (Long) entityManager.createQuery("SELECT COUNT(c) FROM CollectableSeaCreature c").getSingleResult();
        return totalCollectables.intValue();
    }

    //getting the number of collected collectables
    @Override
    @Transactional
    public int getCollectedSeaCreature(int userId) {
        Long collectedCollectables = (Long) entityManager.createQuery("SELECT COUNT(ucf) FROM UserCollectableSeaCreature ucf WHERE ucf.user.id = :userId AND ucf.isCollected = true")
                .setParameter("userId", userId)
                .getSingleResult();
        return collectedCollectables.intValue();
    }

}
