package com.newweb.persist.user;

import com.newweb.domain.user.UserRole;
import com.newweb.domain.user.UserRoleKey;

public interface UserRoleMapper {
    int delete(UserRoleKey key);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole get(UserRoleKey key);

    int updateSelective(UserRole record);

    int update(UserRole record);
}