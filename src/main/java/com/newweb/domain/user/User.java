package com.newweb.domain.user;

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
    private Integer userId;

    /**
     *  用户名
     */
    private String userName;

    /**
     *  密码
     */
    private String userPassword;

    /**
     *  
     */
    private Boolean userLocked;

    /**
     *  用户创建时间
     */
    private Long userCreateDate;

    /**
     *  用户创建者
     */
    private String userCreator;

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
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置字段 system_user.user_id
     *
     * @param userId the value for system_user.user_id
     */
    public void setUserId(Integer userId) {
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

    /**
     * 获取字段 system_user.user_locked
     *
     * @return the value of system_user.user_locked
     */
    public Boolean getUserLocked() {
        return userLocked;
    }

    /**
     * 设置字段 system_user.user_locked
     *
     * @param userLocked the value for system_user.user_locked
     */
    public void setUserLocked(Boolean userLocked) {
        this.userLocked = userLocked;
    }

    /**
     * 获取字段 system_user.user_create_date
     *
     * @return the value of system_user.user_create_date
     */
    public Long getUserCreateDate() {
        return userCreateDate;
    }

    /**
     * 设置字段 system_user.user_create_date
     *
     * @param userCreateDate the value for system_user.user_create_date
     */
    public void setUserCreateDate(Long userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    /**
     * 获取字段 system_user.user_creator
     *
     * @return the value of system_user.user_creator
     */
    public String getUserCreator() {
        return userCreator;
    }

    /**
     * 设置字段 system_user.user_creator
     *
     * @param userCreator the value for system_user.user_creator
     */
    public void setUserCreator(String userCreator) {
        this.userCreator = userCreator == null ? null : userCreator.trim();
    }
}