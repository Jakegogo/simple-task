package com.newweb.persist.security.impl;

import com.newweb.common.persist.AbstractEntityMapper;
import com.newweb.domain.security.UserRole;
import com.newweb.domain.security.UserRoleKey;
import com.newweb.persist.security.UserRoleMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016-2-1.
 */
@Component
public class UserRoleMapperImpl extends AbstractEntityMapper<UserRole, UserRoleKey> implements UserRoleMapper {

    @Override
    protected String namesapceForSqlId() {
        return "com.newweb.persist.security.UserRoleMapper";
    }

    @Override
    public List<String> findRoles(String username) {
        return this.selectList("findRoles", username);
    }
}
