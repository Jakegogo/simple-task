package com.newweb.domain;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class Entity implements IEntity {
    /**
     *  
     */
    private Long id;

    /**
     *  已经领取过的奖励Id
     */
    private String friends;

    /**
     *  
     */
    private String name;

    /**
     *  数字
     */
    private Integer num;

    /**
     *  
     */
    private Integer uid;

    /**
     *  
     */
    private byte[] a;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 entity.id
     *
     * @return the value of entity.id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置字段 entity.id
     *
     * @param id the value for entity.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取字段 entity.friends
     *
     * @return the value of entity.friends
     */
    public String getFriends() {
        return friends;
    }

    /**
     * 设置字段 entity.friends
     *
     * @param friends the value for entity.friends
     */
    public void setFriends(String friends) {
        this.friends = friends == null ? null : friends.trim();
    }

    /**
     * 获取字段 entity.name
     *
     * @return the value of entity.name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置字段 entity.name
     *
     * @param name the value for entity.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取字段 entity.num
     *
     * @return the value of entity.num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置字段 entity.num
     *
     * @param num the value for entity.num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取字段 entity.uid
     *
     * @return the value of entity.uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置字段 entity.uid
     *
     * @param uid the value for entity.uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取字段 entity.a
     *
     * @return the value of entity.a
     */
    public byte[] getA() {
        return a;
    }

    /**
     * 设置字段 entity.a
     *
     * @param a the value for entity.a
     */
    public void setA(byte[] a) {
        this.a = a;
    }
}