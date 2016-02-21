package com.newweb.persist.security;

import com.newweb.common.util.QueryParameters;
import com.newweb.domain.security.PermissionElement;
import java.util.List;

public interface PermissionElementMapper {
    List<PermissionElement> page(QueryParameters queryParam);

    int delete(Long elementId);

    int insert(PermissionElement record);

    int insertSelective(PermissionElement record);

    PermissionElement get(Long elementId);

    int updateSelective(PermissionElement record);

    int update(PermissionElement record);
}