package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.CollectableBug;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CollectableBugDAOImplementation implements CollectableBugDAO {

    private EntityManager entityManager;

    @Autowired
    public CollectableBugDAOImplementation (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //list of all collectables
    @Override
    @Transactional
    public List<CollectableBug> getCollectableList() {
        return entityManager.createQuery("from CollectableBug", CollectableBug.class)
                .getResultList();
    }

    //search by name
    @Override
    @Transactional
    public CollectableBug getCollectableByName(String name) {
        return entityManager.createQuery("SELECT c FROM CollectableBug c WHERE c.name = :name", CollectableBug.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    // update or save the object to the table
    @Override
    @Transactional
    public void updateCollectable(CollectableBug bug) {
        entityManager.merge(bug);
    }

}
