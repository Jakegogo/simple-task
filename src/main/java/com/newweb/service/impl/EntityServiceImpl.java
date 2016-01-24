package com.newweb.service.impl;

import com.newweb.common.assembler.AbstractAssembler;
import com.newweb.controller.dto.EntityDto;
import com.newweb.domain.Entity;
import com.newweb.service.EntityService;
import org.springframework.stereotype.Component;

/**
 * Created by Jake on 1/18 0018.
 */
@Component
public class EntityServiceImpl implements EntityService {

    private AbstractAssembler entityAssembler = new AbstractAssembler<EntityDto, Entity>(){};

}
