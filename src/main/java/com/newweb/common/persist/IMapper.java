package com.newweb.common.persist;

import java.io.Serializable;

/**
 * 仓储访问接口
 * Created by Jake on 1/31 0031.
 */
public interface IMapper <T> {

    /**
     * 添加一条记录
     * @param t T
     * @return
     */
    int insert(T t);

    /**
     * 添加记录
     * (可选字段)
     * @param t T
     * @return
     */
    int insertSelective(T t);

    /**
     * 更新对象
     * @Description: 指定更新
     * @param t T
     * @return int
     */
    int updateSelective(T t);

    /**
     * 更新对象
     * @param t T
     * @return int
     */
    int update(T t);
}
