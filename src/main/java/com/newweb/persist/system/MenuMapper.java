package com.newweb.persist.system;

import com.newweb.domain.system.Menu;

public interface MenuMapper {
    int delete(Long menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu get(Long menuId);

    int updateSelective(Menu record);

    int update(Menu record);
}