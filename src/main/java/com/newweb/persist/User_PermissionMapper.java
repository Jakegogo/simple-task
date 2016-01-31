package com.newweb.persist;

import com.newweb.domain.User_Permission;
import com.newweb.domain.User_PermissionKey;

public interface User_PermissionMapper {
    int delete(User_PermissionKey key);

    int insert(User_Permission record);

    int insertSelective(User_Permission record);

    User_Permission get(User_PermissionKey key);

    int updateSelective(User_Permission record);

    int update(User_Permission record);
}