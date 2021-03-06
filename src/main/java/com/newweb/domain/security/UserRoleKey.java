package com.newweb.domain.security;

import java.io.Serializable;

/**
 *  
 */
public class UserRoleKey implements Serializable {
    /**
     *  用户ID
     */
    private Long userId;

    /**
     *  角色ID
     */
    private Long roleId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_user_role.user_id
     *
     * @return the value of system_user_role.user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置字段 system_user_role.user_id
     *
     * @param userId the value for system_user_role.user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取字段 system_user_role.role_id
     *
     * @return the value of system_user_role.role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置字段 system_user_role.role_id
     *
     * @param roleId the value for system_user_role.role_id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}