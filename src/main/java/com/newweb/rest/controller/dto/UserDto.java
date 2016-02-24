package com.newweb.rest.controller.dto;

/**
 * Created by Jake on 1/18 0018.
 */
public class UserDto {

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getUserLocked() {
        return userLocked;
    }

    public void setUserLocked(Boolean userLocked) {
        this.userLocked = userLocked;
    }

    public Long getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Long userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public String getUserCreator() {
        return userCreator;
    }

    public void setUserCreator(String userCreator) {
        this.userCreator = userCreator;
    }
}
