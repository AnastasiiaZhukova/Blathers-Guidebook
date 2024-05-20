package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.UsersRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;

@Repository
public class UsersRolesDAOImplementation implements UsersRolesDAO{

    private EntityManager entityManager;

    @Autowired
    public UsersRolesDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //saving the user role to the DB
    @Override
    @Transactional
    public void save(UsersRoles usersRoles) {
        entityManager.persist(usersRoles);
    }
}
