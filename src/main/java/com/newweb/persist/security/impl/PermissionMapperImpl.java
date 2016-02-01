package com.newweb.persist.security.impl;

import com.newweb.common.persist.AbstractEntityMapper;
import com.newweb.domain.security.Permission;
import com.newweb.persist.security.PermissionMapper;
import org.springframework.stereotype.Component;

/**
 * 权限存储实现
 * Created by Jake on 1/31 0031.
 */
@Component
public class PermissionMapperImpl extends AbstractEntityMapper<Permission, Long> implements PermissionMapper  {

    @Override
    protected String namesapceForSqlId() {
        return "com.newweb.persist.security.PermissionMapper";
    }

}
