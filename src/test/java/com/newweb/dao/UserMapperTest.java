package com.newweb.dao;

import com.newweb.AbstractBaseTest;
import com.newweb.domain.user.User;
import com.newweb.persist.user.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Jake on 1/31 0031.
 */
public class UserMapperTest extends AbstractBaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void tesGetUserEntity() {
        User user = userMapper.get("312312312");
        System.out.println(user);
    }


}
