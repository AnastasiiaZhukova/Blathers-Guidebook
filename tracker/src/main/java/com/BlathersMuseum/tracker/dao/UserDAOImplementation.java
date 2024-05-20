package com.BlathersMuseum.tracker.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import com.BlathersMuseum.tracker.entity.User;

@Repository
public class UserDAOImplementation implements UserDAO{

    //injecting
    private EntityManager entityManager;
    private PasswordEncoder passwordEncoder;

    //constructor for injected
    @Autowired
    public UserDAOImplementation (EntityManager entityManager, PasswordEncoder passwordEncoder){
        this.entityManager = entityManager;
        this.passwordEncoder = passwordEncoder;
    }

    //saving the user to the db
    @Override
    @Transactional
    public void save(User theUser) {
        User existingUser = searchByUserName(theUser.getUserName());
        if (existingUser == null) {
            theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
        }
        entityManager.persist(theUser);
    }

    //checks the user in the database by userName
    @Override
    @Transactional
    public User searchByUserName(String userName) {
        try {
            TypedQuery<User> query = entityManager.createQuery("FROM User WHERE userName = :userName", User.class);
            query.setParameter("userName", userName);
            return query.getSingleResult();
        } catch (Exception e) {
            return null; 
        }
    }

    //returns true if the username is not unique (matches found)
    @Override
    @Transactional
    public boolean isUserNameNotUnique(String userName) {
        String query = "SELECT count(u) FROM User u WHERE u.userName = :userName";
        Long count = entityManager.createQuery(query, Long.class)
                .setParameter("userName", userName)
                .getSingleResult();
        return count > 0;
    }
}
