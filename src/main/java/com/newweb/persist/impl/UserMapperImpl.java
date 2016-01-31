package com.newweb.persist.impl;

import com.newweb.common.persist.AbstractEntityMapper;
import com.newweb.domain.User;
import com.newweb.persist.UserMapper;
import org.springframework.stereotype.Component;

/**
 * 用户存储实现
 * Created by Jake on 1/31 0031.
 */
@Component
public class UserMapperImpl extends AbstractEntityMapper<User , String> implements UserMapper {

    @Override
    protected String namesapceForSqlId() {
        return "com.newweb.persist.UserMapper";
    }

}
