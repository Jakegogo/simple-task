package com.newweb.domain.security;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class Permission implements IEntity {
    /**
     *  权限ID
     */
    private Long permissionId;

    /**
     *  权限名称
     */
    private String permissionName;

    /**
     *  权限描述
     */
    private String permissionDesc;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_permission.permission_id
     *
     * @return the value of system_permission.permission_id
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 设置字段 system_permission.permission_id
     *
     * @param permissionId the value for system_permission.permission_id
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取字段 system_permission.permission_name
     *
     * @return the value of system_permission.permission_name
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 设置字段 system_permission.permission_name
     *
     * @param permissionName the value for system_permission.permission_name
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * 获取字段 system_permission.permission_desc
     *
     * @return the value of system_permission.permission_desc
     */
    public String getPermissionDesc() {
        return permissionDesc;
    }

    /**
     * 设置字段 system_permission.permission_desc
     *
     * @param permissionDesc the value for system_permission.permission_desc
     */
    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc == null ? null : permissionDesc.trim();
    }

    /**
     * 获取字段 system_permission.permission_id
     *
     * @return the value of system_permission.permission_id
     */
    public Long getId() {
        return permissionId;
    }
}