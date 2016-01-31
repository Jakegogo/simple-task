package com.newweb.persist.impl;

import com.newweb.common.persist.AbstractMapper;
import com.newweb.domain.User_Permission;
import com.newweb.domain.User_PermissionKey;
import com.newweb.persist.User_PermissionMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * 用户权限仓储实现
 * Created by Jake on 1/31 0031.
 */
@Component
public class UserPermissionMapperImpl extends AbstractMapper<User_Permission> implements User_PermissionMapper {

    @Override
    protected String namesapceForSqlId() {
        return "com.newweb.persist.User_PermissionMapper";
    }

    @Override
    public int delete(User_PermissionKey key) {
        int count;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            count = session.delete(fullSqlId("delete"), key);
            session.commit(true);
        }
        return count;
    }

    @Override
    public User_Permission get(User_PermissionKey key) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne(fullSqlId("get"), key);
        }
    }
}
