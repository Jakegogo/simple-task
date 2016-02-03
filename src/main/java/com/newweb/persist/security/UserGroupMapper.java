package com.newweb.persist.security;

import com.newweb.domain.security.UserGroup;
import com.newweb.domain.security.UserGroupKey;

public interface UserGroupMapper {
    int delete(UserGroupKey key);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup get(UserGroupKey key);

    int updateSelective(UserGroup record);

    int update(UserGroup record);
}