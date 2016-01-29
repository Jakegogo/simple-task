package com.newweb.persist.impl;

import com.newweb.common.persist.AbstractEntityMapper;
import com.newweb.domain.Entity;
import com.newweb.persist.EntityMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Jake on 1/17 0017.
 */
@Component
public class EntityMapperImpl extends AbstractEntityMapper<Entity, String> implements EntityMapper {

    @Override
    protected String namesapceForSqlId() {
        return "com.newweb.persist.EntityMapper";
    }

}
