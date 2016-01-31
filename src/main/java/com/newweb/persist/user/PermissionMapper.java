package com.newweb.persist.user;

import com.newweb.domain.user.Permission;

public interface PermissionMapper {
    int delete(Long permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission get(Long permissionId);

    int updateSelective(Permission record);

    int update(Permission record);
}