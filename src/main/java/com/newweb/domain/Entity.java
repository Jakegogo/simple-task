package com.newweb.domain;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class Entity implements IEntity {
    /**
     *  
     */
    private String id;

    /**
     *  
     */
    private Integer groupId;

    /**
     *  
     */
    private Integer userId;

    /**
     *  
     */
    private String desc;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 entity.id
     *
     * @return the value of entity.id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置字段 entity.id
     *
     * @param id the value for entity.id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取字段 entity.group_id
     *
     * @return the value of entity.group_id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置字段 entity.group_id
     *
     * @param groupId the value for entity.group_id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取字段 entity.user_id
     *
     * @return the value of entity.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置字段 entity.user_id
     *
     * @param userId the value for entity.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取字段 entity.desc
     *
     * @return the value of entity.desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置字段 entity.desc
     *
     * @param desc the value for entity.desc
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}