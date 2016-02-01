package com.newweb.persist.user.impl;

import com.newweb.common.persist.AbstractEntityMapper;
import com.newweb.domain.user.User;
import com.newweb.persist.user.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 用户存储实现
 * Created by Jake on 1/31 0031.
 */
@Component
public class UserMapperImpl extends AbstractEntityMapper<User , String> implements UserMapper {

    @Override
    protected String namesapceForSqlId() {
        return "com.newweb.persist.user.UserMapper";
    }

    @Override
    public User findByUsername(String username) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne(fullSqlId("findByUsername"), username);
        }
    }

}
