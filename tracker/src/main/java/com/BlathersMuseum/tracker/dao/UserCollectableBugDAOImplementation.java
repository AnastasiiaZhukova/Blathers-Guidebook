package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.UserCollectableBug;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserCollectableBugDAOImplementation implements UserCollectableBugDAO {

    //entity manager
    private EntityManager entityManager;

    @Autowired
    public UserCollectableBugDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //get list of user collectables
    @Override
    @Transactional
    public List<UserCollectableBug> getUserCollectableList(int userId) {
        return entityManager.createQuery("SELECT ucf FROM UserCollectableBug ucf WHERE ucf.user.id = :userId", UserCollectableBug.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    //save
    @Override
    @Transactional
    public void saveUserCollectable(UserCollectableBug userCollectableBug) {
        entityManager.merge(userCollectableBug);
    }

    //getting by id
    @Override
    @Transactional
    public UserCollectableBug getUserCollectable(int userId, int collectableId) {
        return entityManager.createQuery("SELECT ucf FROM UserCollectableBug ucf WHERE ucf.user.id = :userId AND ucf.collectableBug.collectableId = :collectableId", UserCollectableBug.class)
                .setParameter("userId", userId)
                .setParameter("collectableId", collectableId)
                .getSingleResult();
    }

    //getting the number of collectables
    @Override
    @Transactional
    public int getTotalBugCollectables() {
        Long totalCollectables = (Long) entityManager.createQuery("SELECT COUNT(c) FROM CollectableBug c").getSingleResult();
        return totalCollectables.intValue();
    }

    //getting the number of collected collectables
    @Override
    @Transactional
    public int getCollectedBug(int userId) {
        Long collectedCollectables = (Long) entityManager.createQuery("SELECT COUNT(ucf) FROM UserCollectableBug ucf WHERE ucf.user.id = :userId AND ucf.isCollected = true")
                .setParameter("userId", userId)
                .getSingleResult();
        return collectedCollectables.intValue();
    }

}
