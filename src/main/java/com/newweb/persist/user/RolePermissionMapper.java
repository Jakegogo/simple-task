package com.newweb.persist.user;

import com.newweb.domain.user.RolePermission;
import com.newweb.domain.user.RolePermissionKey;

public interface RolePermissionMapper {
    int delete(RolePermissionKey key);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission get(RolePermissionKey key);

    int updateSelective(RolePermission record);

    int update(RolePermission record);
}