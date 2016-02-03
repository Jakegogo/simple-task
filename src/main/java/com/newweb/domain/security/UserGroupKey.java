package com.newweb.domain.security;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class UserGroupKey implements IEntity {
    /**
     *  组ID
     */
    private Long groupId;

    /**
     *  用户ID
     */
    private Long userId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_user_group.group_id
     *
     * @return the value of system_user_group.group_id
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置字段 system_user_group.group_id
     *
     * @param groupId the value for system_user_group.group_id
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取字段 system_user_group.user_id
     *
     * @return the value of system_user_group.user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置字段 system_user_group.user_id
     *
     * @param userId the value for system_user_group.user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getId() {
        return null;
    }
}