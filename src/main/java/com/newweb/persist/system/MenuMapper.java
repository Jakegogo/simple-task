package com.newweb.persist.system;

import com.newweb.common.util.QueryParameters;
import com.newweb.domain.system.Menu;
import java.util.List;

public interface MenuMapper {
    List<Menu> page(QueryParameters queryParam);

    int count(QueryParameters queryParam);

    int delete(Long menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu get(Long menuId);

    int updateSelective(Menu record);

    int update(Menu record);
}