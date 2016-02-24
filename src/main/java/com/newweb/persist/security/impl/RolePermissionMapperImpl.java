package com.newweb.persist.security.impl;

import com.newweb.common.persist.AbstractEntityMapper;
import com.newweb.common.security.RequestPermission;
import com.newweb.domain.security.RolePermission;
import com.newweb.domain.security.RolePermissionKey;
import com.newweb.persist.security.RolePermissionMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户权限仓储实现
 * Created by Jake on 1/31 0031.
 */
@Component
public class RolePermissionMapperImpl extends AbstractEntityMapper<RolePermission, RolePermissionKey> implements RolePermissionMapper {

    @Override
    protected String namesapceForSqlId() {
        return "com.newweb.persist.security.RolePermissionMapper";
    }

    @Override
    public List<RequestPermission> findPermissions(String username) {
        return this.selectList("findPermissions", username);
    }

}
