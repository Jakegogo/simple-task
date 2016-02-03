package com.newweb.domain.security;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class UserGroup extends UserGroupKey implements IEntity {
    /**
     *  创建者
     */
    private String userGroupCreator;

    /**
     *  用户组描述
     */
    private String userGroupDesc;

    /**
     *  创建时间
     */
    private Long createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_user_group.user_group_creator
     *
     * @return the value of system_user_group.user_group_creator
     */
    public String getUserGroupCreator() {
        return userGroupCreator;
    }

    /**
     * 设置字段 system_user_group.user_group_creator
     *
     * @param userGroupCreator the value for system_user_group.user_group_creator
     */
    public void setUserGroupCreator(String userGroupCreator) {
        this.userGroupCreator = userGroupCreator == null ? null : userGroupCreator.trim();
    }

    /**
     * 获取字段 system_user_group.user_group_desc
     *
     * @return the value of system_user_group.user_group_desc
     */
    public String getUserGroupDesc() {
        return userGroupDesc;
    }

    /**
     * 设置字段 system_user_group.user_group_desc
     *
     * @param userGroupDesc the value for system_user_group.user_group_desc
     */
    public void setUserGroupDesc(String userGroupDesc) {
        this.userGroupDesc = userGroupDesc == null ? null : userGroupDesc.trim();
    }

    /**
     * 获取字段 system_user_group.create_time
     *
     * @return the value of system_user_group.create_time
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 设置字段 system_user_group.create_time
     *
     * @param createTime the value for system_user_group.create_time
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return null;
    }
}