package com.newweb.persist.security;

import com.newweb.domain.security.UserRole;
import com.newweb.domain.security.UserRoleKey;

public interface UserRoleMapper {
    int delete(UserRoleKey key);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole get(UserRoleKey key);

    int updateSelective(UserRole record);

    int update(UserRole record);
}