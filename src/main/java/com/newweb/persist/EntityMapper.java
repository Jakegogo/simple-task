package com.newweb.persist;

import com.newweb.domain.Entity;

public interface EntityMapper {
    int delete(Long id);

    int insert(Entity record);

    int insertSelective(Entity record);

    Entity get(Long id);

    int updateSelective(Entity record);

    int updateWithBLOBs(Entity record);

    int update(Entity record);
}