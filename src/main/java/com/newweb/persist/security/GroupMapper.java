package com.newweb.persist.security;

import com.newweb.domain.security.Group;

public interface GroupMapper {
    int delete(Long groupId);

    int insert(Group record);

    int insertSelective(Group record);

    Group get(Long groupId);

    int updateSelective(Group record);

    int update(Group record);
}