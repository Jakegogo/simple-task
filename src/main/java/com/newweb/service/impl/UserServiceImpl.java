package com.newweb.service.impl;

import com.newweb.domain.user.User;
import com.newweb.persist.security.RolePermissionMapper;
import com.newweb.persist.security.UserRoleMapper;
import com.newweb.persist.user.UserMapper;
import com.newweb.rest.controller.dto.assembler.UserAssembler;
import com.newweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Jake on 1/18 0018.
 */
@Component
public class UserServiceImpl implements UserService {

    private UserAssembler  entityAssembler = new UserAssembler();

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        List<String> userRoles = userRoleMapper.findRoles(username);
        if (userRoles == null) {
            return Collections.emptySet();
        }
        return new HashSet(userRoles);
    }

    @Override
    public Set<String> findPermissions(String username) {
        List<String> userPermissions = rolePermissionMapper.findPermissions(username);
        if (userPermissions == null) {
            return Collections.emptySet();
        }
        return new TreeSet(userPermissions);
    }
}
