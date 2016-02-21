package com.newweb.persist.security;

import com.newweb.domain.security.UserRole;
import com.newweb.domain.security.UserRoleKey;

import java.util.List;

public interface UserRoleMapper {
    int delete(UserRoleKey key);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole get(UserRoleKey key);

    int updateSelective(UserRole record);

    int update(UserRole record);

    /**
     * 查询角色名
     * @param username 用户名
     * @return
     */
    List<String> findRoles(String username);
}