package com.newweb.service;

import com.newweb.common.util.QueryParameters;
import com.newweb.domain.user.User;
import com.newweb.rest.controller.dto.UserDto;

import java.util.Collection;
import java.util.Set;

/**
 * 用户Service接口
 * Created by Jake on 1/18 0018.
 */
public interface UserService {

    /**
     * 分页
     * @param queryParam 分页查询参数
     * @return
     */
    Collection<UserDto> page(QueryParameters queryParam);

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return
     */
    User findByUsername(String username);

    /**
     * 查询角色名
     * @param username 用户名
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 查询权限
     * @param username 用户名
     * @return
     */
    Set<String> findPermissions(String username);
}
