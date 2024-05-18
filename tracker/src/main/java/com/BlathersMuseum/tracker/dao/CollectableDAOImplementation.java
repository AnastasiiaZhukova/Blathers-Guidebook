package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.Collectable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CollectableDAOImplementation implements CollectableDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Collectable> getCollectables() {
        return entityManager.createQuery("from Collectable", Collectable.class).getResultList();
    }

    @Override
    @Transactional
    public Collectable getCollectableByName(String name) {
        return entityManager.find(Collectable.class, name);
    }

    @Override
    @Transactional
    public void updateCollectable(Collectable collectable) {
        entityManager.merge(collectable);
    }
}