package com.newweb.persist.security;

import com.newweb.common.util.QueryParameters;
import com.newweb.domain.security.Permission;
import java.util.List;

public interface PermissionMapper {
    List<Permission> page(QueryParameters queryParam);

    int delete(Long permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission get(Long permissionId);

    int updateSelective(Permission record);

    int update(Permission record);
}