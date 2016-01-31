package com.newweb.domain.user;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class UserRole extends UserRoleKey implements IEntity {
    /**
     *  
     */
    private String userRoleDesc;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_user_role.user_role_desc
     *
     * @return the value of system_user_role.user_role_desc
     */
    public String getUserRoleDesc() {
        return userRoleDesc;
    }

    /**
     * 设置字段 system_user_role.user_role_desc
     *
     * @param userRoleDesc the value for system_user_role.user_role_desc
     */
    public void setUserRoleDesc(String userRoleDesc) {
        this.userRoleDesc = userRoleDesc == null ? null : userRoleDesc.trim();
    }

    public String getId() {
        return null;
    }
}