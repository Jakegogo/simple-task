package com.newweb.domain;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class User implements IEntity {
    /**
     *  主键
     */
    private String id;

    /**
     *  用户ID
     */
    private Long userId;

    /**
     *  用户名
     */
    private String userName;

    /**
     *  密码
     */
    private String userPassword;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_user.id
     *
     * @return the value of system_user.id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置字段 system_user.id
     *
     * @param id the value for system_user.id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取字段 system_user.user_id
     *
     * @return the value of system_user.user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置字段 system_user.user_id
     *
     * @param userId the value for system_user.user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取字段 system_user.user_name
     *
     * @return the value of system_user.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置字段 system_user.user_name
     *
     * @param userName the value for system_user.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取字段 system_user.user_password
     *
     * @return the value of system_user.user_password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置字段 system_user.user_password
     *
     * @param userPassword the value for system_user.user_password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }
}