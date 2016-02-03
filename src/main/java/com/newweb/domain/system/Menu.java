package com.newweb.domain.system;

import com.newweb.common.domain.IEntity;

/**
 *  

 */
public class Menu implements IEntity {
    /**
     *  
     */
    private Long menuId;

    /**
     *  
     */
    private Long permissionId;

    /**
     *  
     */
    private String menuName;

    /**
     *  
     */
    private String menuUrl;

    /**
     *  
     */
    private String menuDesc;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 system_menu.menu_id
     *
     * @return the value of system_menu.menu_id
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置字段 system_menu.menu_id
     *
     * @param menuId the value for system_menu.menu_id
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取字段 system_menu.permission_id
     *
     * @return the value of system_menu.permission_id
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 设置字段 system_menu.permission_id
     *
     * @param permissionId the value for system_menu.permission_id
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取字段 system_menu.menu_name
     *
     * @return the value of system_menu.menu_name
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置字段 system_menu.menu_name
     *
     * @param menuName the value for system_menu.menu_name
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取字段 system_menu.menu_url
     *
     * @return the value of system_menu.menu_url
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置字段 system_menu.menu_url
     *
     * @param menuUrl the value for system_menu.menu_url
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * 获取字段 system_menu.menu_desc
     *
     * @return the value of system_menu.menu_desc
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * 设置字段 system_menu.menu_desc
     *
     * @param menuDesc the value for system_menu.menu_desc
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc == null ? null : menuDesc.trim();
    }

    /**
     * 获取字段 system_menu.menu_id
     *
     * @return the value of system_menu.menu_id
     */
    public Long getId() {
        return menuId;
    }
}