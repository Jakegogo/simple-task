package com.newweb.persist.security.impl;

import com.newweb.common.persist.AbstractMapper;
import com.newweb.domain.security.RolePermission;
import com.newweb.domain.security.RolePermissionKey;
import com.newweb.domain.security.UserRole;
import com.newweb.domain.security.UserRoleKey;
import com.newweb.persist.security.RolePermissionMapper;
import com.newweb.persist.security.UserRoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016-2-1.
 */
@Component
public class UserRoleMapperImpl extends AbstractMapper<UserRole> implements UserRoleMapper {

    @Override
    public List<String> findRoles(String username) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList(fullSqlId("findRoles"), username);
        }
    }

    @Override
    protected String namesapceForSqlId() {
        return "com.newweb.persist.security.UserRoleMapper";
    }

    @Override
    public int delete(UserRoleKey key) {
        int count;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            count = session.delete(fullSqlId("delete"), key);
            session.commit(true);
        }
        return count;
    }

    @Override
    public UserRole get(UserRoleKey key) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne(fullSqlId("get"), key);
        }
    }

}
