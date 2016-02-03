package com.newweb.persist.security;

import com.newweb.domain.security.PermissionElement;

public interface PermissionElementMapper {
    int delete(Long elementId);

    int insert(PermissionElement record);

    int insertSelective(PermissionElement record);

    PermissionElement get(Long elementId);

    int updateSelective(PermissionElement record);

    int update(PermissionElement record);
}