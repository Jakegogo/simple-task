package com.newweb.service.impl;

import com.newweb.rest.controller.dto.assembler.UserAssembler;
import com.newweb.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Created by Jake on 1/18 0018.
 */
@Component
public class UserServiceImpl implements UserService {

    private UserAssembler  entityAssembler = new UserAssembler();



}
