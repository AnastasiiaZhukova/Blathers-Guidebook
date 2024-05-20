package com.BlathersMuseum.tracker.dao;
import com.BlathersMuseum.tracker.entity.User;

public interface UserDAO {
    void save (User theUser);
    User searchByUserName(String userName);
    boolean isUserNameNotUnique(String userName);
}
