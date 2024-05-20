package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.AppliedUsers;

import java.util.List;


public interface AppliedUsersDAO {

    AppliedUsers searchByUserName(String userName);
    void save(AppliedUsers appliedUsers);
    List<AppliedUsers> getAllAppliedUsers();
}
