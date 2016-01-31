package com.newweb.persist.user;

import com.newweb.domain.user.Role;

public interface RoleMapper {
    int delete(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role get(Long roleId);

    int updateSelective(Role record);

    int update(Role record);
}