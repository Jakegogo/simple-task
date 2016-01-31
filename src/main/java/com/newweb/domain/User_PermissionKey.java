package com.newweb.domain;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class User_PermissionKey implements IEntity {
    /**
     *  用户ID
     */
    private Long userId;

    /**
     *  权限ID
     */
    private Long permissionId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_user_permission.user_id
     *
     * @return the value of system_user_permission.user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置字段 system_user_permission.user_id
     *
     * @param userId the value for system_user_permission.user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取字段 system_user_permission.permission_id
     *
     * @return the value of system_user_permission.permission_id
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 设置字段 system_user_permission.permission_id
     *
     * @param permissionId the value for system_user_permission.permission_id
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getId() {
        return null;
    }
}