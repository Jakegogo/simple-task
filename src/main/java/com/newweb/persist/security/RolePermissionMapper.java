package com.newweb.persist.security;

import com.newweb.common.security.RequestPermission;
import com.newweb.domain.security.RolePermission;
import com.newweb.domain.security.RolePermissionKey;

import java.util.List;

public interface RolePermissionMapper {
    int delete(RolePermissionKey key);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission get(RolePermissionKey key);

    int updateSelective(RolePermission record);

    int update(RolePermission record);

    /**
     * 查询权限
     * @param username 用户名
     * @return
     */
    List<RequestPermission> findPermissions(String username);
}