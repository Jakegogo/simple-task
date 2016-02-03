package com.newweb.domain.security;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class PermissionElement implements IEntity {
    /**
     *  权限元素ID
     */
    private Long elementId;

    /**
     *  权限元素名称
     */
    private String elementName;

    /**
     *  权限ID
     */
    private Long permissionId;

    /**
     *  元素类型
     */
    private Integer elementType;

    /**
     *  元素Key
     */
    private String elementKey;

    /**
     *  元素值
     */
    private String elementValue;

    /**
     *  额外信息
     */
    private String elementExtra;

    /**
     *  权限元素描述
     */
    private String elementDesc;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_permission_element.element_id
     *
     * @return the value of system_permission_element.element_id
     */
    public Long getElementId() {
        return elementId;
    }

    /**
     * 设置字段 system_permission_element.element_id
     *
     * @param elementId the value for system_permission_element.element_id
     */
    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    /**
     * 获取字段 system_permission_element.element_name
     *
     * @return the value of system_permission_element.element_name
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * 设置字段 system_permission_element.element_name
     *
     * @param elementName the value for system_permission_element.element_name
     */
    public void setElementName(String elementName) {
        this.elementName = elementName == null ? null : elementName.trim();
    }

    /**
     * 获取字段 system_permission_element.permission_id
     *
     * @return the value of system_permission_element.permission_id
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 设置字段 system_permission_element.permission_id
     *
     * @param permissionId the value for system_permission_element.permission_id
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取字段 system_permission_element.element_type
     *
     * @return the value of system_permission_element.element_type
     */
    public Integer getElementType() {
        return elementType;
    }

    /**
     * 设置字段 system_permission_element.element_type
     *
     * @param elementType the value for system_permission_element.element_type
     */
    public void setElementType(Integer elementType) {
        this.elementType = elementType;
    }

    /**
     * 获取字段 system_permission_element.element_key
     *
     * @return the value of system_permission_element.element_key
     */
    public String getElementKey() {
        return elementKey;
    }

    /**
     * 设置字段 system_permission_element.element_key
     *
     * @param elementKey the value for system_permission_element.element_key
     */
    public void setElementKey(String elementKey) {
        this.elementKey = elementKey == null ? null : elementKey.trim();
    }

    /**
     * 获取字段 system_permission_element.element_value
     *
     * @return the value of system_permission_element.element_value
     */
    public String getElementValue() {
        return elementValue;
    }

    /**
     * 设置字段 system_permission_element.element_value
     *
     * @param elementValue the value for system_permission_element.element_value
     */
    public void setElementValue(String elementValue) {
        this.elementValue = elementValue == null ? null : elementValue.trim();
    }

    /**
     * 获取字段 system_permission_element.element_extra
     *
     * @return the value of system_permission_element.element_extra
     */
    public String getElementExtra() {
        return elementExtra;
    }

    /**
     * 设置字段 system_permission_element.element_extra
     *
     * @param elementExtra the value for system_permission_element.element_extra
     */
    public void setElementExtra(String elementExtra) {
        this.elementExtra = elementExtra == null ? null : elementExtra.trim();
    }

    /**
     * 获取字段 system_permission_element.element_desc
     *
     * @return the value of system_permission_element.element_desc
     */
    public String getElementDesc() {
        return elementDesc;
    }

    /**
     * 设置字段 system_permission_element.element_desc
     *
     * @param elementDesc the value for system_permission_element.element_desc
     */
    public void setElementDesc(String elementDesc) {
        this.elementDesc = elementDesc == null ? null : elementDesc.trim();
    }

    /**
     * 获取字段 system_permission_element.element_id
     *
     * @return the value of system_permission_element.element_id
     */
    public Long getId() {
        return elementId;
    }
}