package com.newweb.persist;

import com.newweb.domain.Entity;

public interface EntityMapper {
    int delete(String id);

    int insert(Entity record);

    int insertSelective(Entity record);

    Entity get(String id);

    int updateSelective(Entity record);

    int update(Entity record);
}