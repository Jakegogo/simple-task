package com.newweb.persist.security;

import com.newweb.domain.security.RolePermission;
import com.newweb.domain.security.RolePermissionKey;

public interface RolePermissionMapper {
    int delete(RolePermissionKey key);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission get(RolePermissionKey key);

    int updateSelective(RolePermission record);

    int update(RolePermission record);
}