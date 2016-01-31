package com.newweb.persist;

import com.newweb.domain.User;

public interface UserMapper {
    int delete(String id);

    int insert(User record);

    int insertSelective(User record);

    User get(String id);

    int updateSelective(User record);

    int update(User record);
}