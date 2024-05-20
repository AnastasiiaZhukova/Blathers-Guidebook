package com.BlathersMuseum.tracker.dao;

import com.BlathersMuseum.tracker.entity.Role;

public interface RoleDAO {

    Role searchByRoleName(String roleName);
}
