package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.CollectableFish;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CollectableFishDAOImplementation implements CollectableFishDAO {

    private EntityManager entityManager;

    @Autowired
    public CollectableFishDAOImplementation (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //list of all collectables
    @Override
    @Transactional
    public List<CollectableFish> getCollectableList() {
        return entityManager.createQuery("from CollectableFish", CollectableFish.class)
                .getResultList();
    }

    //search by name
    @Override
    @Transactional
    public CollectableFish getCollectableByName(String name) {
        return entityManager.createQuery("SELECT c FROM CollectableFish c WHERE c.name = :name", CollectableFish.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    // update or save the object to the table
    @Override
    @Transactional
    public void updateCollectable(CollectableFish fish) {
        entityManager.merge(fish);
    }

}
