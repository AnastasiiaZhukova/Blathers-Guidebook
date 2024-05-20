package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.AppliedUsers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class AppliedUsersDAOImplementation implements AppliedUsersDAO {

    private EntityManager entityManager;

    @Autowired
    public AppliedUsersDAOImplementation (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //search by username
    @Override
    @Transactional
    public AppliedUsers searchByUserName(String userName) {
        try {
            TypedQuery<AppliedUsers> query = entityManager.createQuery("FROM AppliedUsers WHERE userName = :userName", AppliedUsers.class);
            query.setParameter("userName", userName);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    //save
    @Override
    @Transactional
    public void save(AppliedUsers appliedUsers) {
        entityManager.persist(appliedUsers);
    }

    //get the list of all
    @Override
    @Transactional
    public List<AppliedUsers> getAllAppliedUsers() {
        TypedQuery<AppliedUsers> query = entityManager.createQuery("FROM AppliedUsers", AppliedUsers.class);

        return query.getResultList();
    }

}
