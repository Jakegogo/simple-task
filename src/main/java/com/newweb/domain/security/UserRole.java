package com.newweb.domain.security;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class UserRole extends UserRoleKey implements IEntity {
    /**
     *  创建者
     */
    private String userRoleCreator;

    /**
     *  用户角色描述
     */
    private String userRoleDesc;

    /**
     *  创建时间戳
     */
    private Long createDate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_user_role.user_role_creator
     *
     * @return the value of system_user_role.user_role_creator
     */
    public String getUserRoleCreator() {
        return userRoleCreator;
    }

    /**
     * 设置字段 system_user_role.user_role_creator
     *
     * @param userRoleCreator the value for system_user_role.user_role_creator
     */
    public void setUserRoleCreator(String userRoleCreator) {
        this.userRoleCreator = userRoleCreator == null ? null : userRoleCreator.trim();
    }

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

    /**
     * 获取字段 system_user_role.create_date
     *
     * @return the value of system_user_role.create_date
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * 设置字段 system_user_role.create_date
     *
     * @param createDate the value for system_user_role.create_date
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getId() {
        return null;
    }
}