package com.newweb.domain.security;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class Role implements IEntity {
    /**
     *  角色ID
     */
    private Long roleId;

    /**
     *  角色名称
     */
    private String roleName;

    /**
     *  描述
     */
    private String roleDesc;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_role.role_id
     *
     * @return the value of system_role.role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置字段 system_role.role_id
     *
     * @param roleId the value for system_role.role_id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取字段 system_role.role_name
     *
     * @return the value of system_role.role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置字段 system_role.role_name
     *
     * @param roleName the value for system_role.role_name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取字段 system_role.role_desc
     *
     * @return the value of system_role.role_desc
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * 设置字段 system_role.role_desc
     *
     * @param roleDesc the value for system_role.role_desc
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    /**
     * 获取字段 system_role.role_id
     *
     * @return the value of system_role.role_id
     */
    public Long getId() {
        return roleId;
    }
}