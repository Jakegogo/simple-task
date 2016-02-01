package com.newweb.persist.security.impl;

import com.newweb.common.persist.AbstractMapper;
import com.newweb.domain.security.RolePermission;
import com.newweb.domain.security.RolePermissionKey;
import com.newweb.persist.security.RolePermissionMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户权限仓储实现
 * Created by Jake on 1/31 0031.
 */
@Component
public class RolePermissionMapperImpl extends AbstractMapper<RolePermission> implements RolePermissionMapper {

    @Override
    protected String namesapceForSqlId() {
        return "com.newweb.persist.security.RolePermissionMapper";
    }

    @Override
    public int delete(RolePermissionKey key) {
        int count;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            count = session.delete(fullSqlId("delete"), key);
            session.commit(true);
        }
        return count;
    }

    @Override
    public RolePermission get(RolePermissionKey key) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne(fullSqlId("get"), key);
        }
    }

    @Override
    public List<String> findPermissions(String username) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList(fullSqlId("findPermissions"), username);
        }
    }

}
