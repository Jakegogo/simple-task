package com.newweb.persist.security;

import com.newweb.common.util.QueryParameters;
import com.newweb.domain.security.Group;
import java.util.List;

public interface GroupMapper {
    List<Group> page(QueryParameters queryParam);

    int count(QueryParameters queryParam);

    int delete(Long groupId);

    int insert(Group record);

    int insertSelective(Group record);

    Group get(Long groupId);

    int updateSelective(Group record);

    int update(Group record);
}