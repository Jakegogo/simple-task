package com.newweb.domain;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class User_Permission extends User_PermissionKey implements IEntity {
    /**
     *  
     */
    private String desc;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_user_permission.desc
     *
     * @return the value of system_user_permission.desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置字段 system_user_permission.desc
     *
     * @param desc the value for system_user_permission.desc
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getId() {
        return null;
    }
}