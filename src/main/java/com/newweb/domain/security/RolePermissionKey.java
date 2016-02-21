package com.newweb.domain.security;

import java.io.Serializable;

/**
 *  
 */
public class RolePermissionKey implements Serializable {
    /**
     *  角色ID
     */
    private Long roleId;

    /**
     *  权限ID
     */
    private Long permissionId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_role_permission.role_id
     *
     * @return the value of system_role_permission.role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置字段 system_role_permission.role_id
     *
     * @param roleId the value for system_role_permission.role_id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取字段 system_role_permission.permission_id
     *
     * @return the value of system_role_permission.permission_id
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 设置字段 system_role_permission.permission_id
     *
     * @param permissionId the value for system_role_permission.permission_id
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}