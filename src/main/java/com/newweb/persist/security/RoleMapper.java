package com.newweb.persist.security;

import com.newweb.common.util.QueryParameters;
import com.newweb.domain.security.Role;
import java.util.List;

public interface RoleMapper {
    List<Role> page(QueryParameters queryParam);

    int delete(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role get(Long roleId);

    int updateSelective(Role record);

    int update(Role record);
}