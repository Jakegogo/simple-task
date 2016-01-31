package com.newweb.persist.security;

import com.newweb.domain.security.Role;

public interface RoleMapper {
    int delete(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role get(Long roleId);

    int updateSelective(Role record);

    int update(Role record);
}