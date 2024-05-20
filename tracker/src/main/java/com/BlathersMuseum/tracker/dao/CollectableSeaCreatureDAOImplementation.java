package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.CollectableSeaCreature;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CollectableSeaCreatureDAOImplementation implements CollectableSeaCreatureDAO {

    private EntityManager entityManager;

    @Autowired
    public CollectableSeaCreatureDAOImplementation (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //list of all collectables
    @Override
    @Transactional
    public List<CollectableSeaCreature> getCollectableList() {
        return entityManager.createQuery("from CollectableSeaCreature", CollectableSeaCreature.class)
                .getResultList();
    }

    //search by name
    @Override
    @Transactional
    public CollectableSeaCreature getCollectableByName(String name) {
        return entityManager.createQuery("SELECT c FROM CollectableSeaCreature c WHERE c.name = :name", CollectableSeaCreature.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    // update or save the object to the table
    @Override
    @Transactional
    public void updateCollectable(CollectableSeaCreature seaCreature) {
        entityManager.merge(seaCreature);
    }

}
