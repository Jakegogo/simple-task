package com.newweb.service.impl;

import com.newweb.common.assembler.AbstractAssembler;
import com.newweb.controller.dto.UserDto;
import com.newweb.controller.dto.assembler.UserAssembler;
import com.newweb.domain.User;
import com.newweb.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Created by Jake on 1/18 0018.
 */
@Component
public class UserServiceImpl implements UserService {

    private UserAssembler  entityAssembler = new UserAssembler();



}
