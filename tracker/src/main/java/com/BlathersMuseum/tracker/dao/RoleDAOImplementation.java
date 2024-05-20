package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class RoleDAOImplementation implements RoleDAO {

    //injecting & constructing entity manager
    private EntityManager entityManager;

    @Autowired
    public RoleDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //getting the role by role name
    @Override
    public Role searchByRoleName(String roleName) {
        TypedQuery<Role> query = entityManager.createQuery("FROM Role WHERE roleName = :roleName", Role.class);
        query.setParameter("roleName", roleName);
        return query.getSingleResult();
    }
}
