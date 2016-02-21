package com.newweb.domain.security;

import com.newweb.common.domain.IEntity;

/**
 *  
 */
public class Group implements IEntity {
    /**
     *  组ID
     */
    private Long groupId;

    /**
     *  组名称
     */
    private String groupName;

    /**
     *  上级组ID
     */
    private Long groupParent;

    /**
     *  组描述
     */
    private String groupDesc;

    /**
     *  分组创建者
     */
    private String groupCreator;

    /**
     *  分组创建时间
     */
    private Long groupCreateDate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_group.group_id
     *
     * @return the value of system_group.group_id
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置字段 system_group.group_id
     *
     * @param groupId the value for system_group.group_id
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取字段 system_group.group_name
     *
     * @return the value of system_group.group_name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置字段 system_group.group_name
     *
     * @param groupName the value for system_group.group_name
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 获取字段 system_group.group_parent
     *
     * @return the value of system_group.group_parent
     */
    public Long getGroupParent() {
        return groupParent;
    }

    /**
     * 设置字段 system_group.group_parent
     *
     * @param groupParent the value for system_group.group_parent
     */
    public void setGroupParent(Long groupParent) {
        this.groupParent = groupParent;
    }

    /**
     * 获取字段 system_group.group_desc
     *
     * @return the value of system_group.group_desc
     */
    public String getGroupDesc() {
        return groupDesc;
    }

    /**
     * 设置字段 system_group.group_desc
     *
     * @param groupDesc the value for system_group.group_desc
     */
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc == null ? null : groupDesc.trim();
    }

    /**
     * 获取字段 system_group.group_creator
     *
     * @return the value of system_group.group_creator
     */
    public String getGroupCreator() {
        return groupCreator;
    }

    /**
     * 设置字段 system_group.group_creator
     *
     * @param groupCreator the value for system_group.group_creator
     */
    public void setGroupCreator(String groupCreator) {
        this.groupCreator = groupCreator == null ? null : groupCreator.trim();
    }

    /**
     * 获取字段 system_group.group_create_date
     *
     * @return the value of system_group.group_create_date
     */
    public Long getGroupCreateDate() {
        return groupCreateDate;
    }

    /**
     * 设置字段 system_group.group_create_date
     *
     * @param groupCreateDate the value for system_group.group_create_date
     */
    public void setGroupCreateDate(Long groupCreateDate) {
        this.groupCreateDate = groupCreateDate;
    }

    /**
     * 获取字段 system_group.group_id
     *
     * @return the value of system_group.group_id
     */
    public Long getId() {
        return groupId;
    }
}