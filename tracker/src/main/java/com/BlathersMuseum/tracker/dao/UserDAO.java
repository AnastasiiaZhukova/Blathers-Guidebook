package com.BlathersMuseum.tracker.dao;
import com.BlathersMuseum.tracker.entity.User;

public interface UserDAO {

    //saving the user to the db
    void save (User theUser);

    //checks the user in the database by userName
    User searchByUserName(String userName);

    //return true if the username is not unique (matches found)
    boolean isUserNameNotUnique(String userName);
}
