package com.newweb.common.persist;

import com.newweb.common.domain.IEntity;
import com.newweb.common.util.QueryParameters;

import java.io.Serializable;
import java.util.List;


/**
 * 仓储访问接口, 提供通用仓储方法
 * @author Jake
 * @Data 2016年1月17日
 * @Version 1.0.0
 */
public interface IEntityMapper<T extends IEntity, PK extends Serializable> {

	/**
	 * 根据实体ID，查找实体
	 * 
	 * @param id
	 * @return
	 */
	T get(PK id);

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
	 * 保存一个实体
	 * 
	 * @param t
	 */
	void save(T t);

	/**
	 * 根据实体ID，删除实体
	 * 
	 * @param id
	 */
	int delete(PK id);

	/**
	 * 查询符合查询参数的实体结果集数量
	 * 
	 * @param param
	 * @return
	 */
	int findResultCount(QueryParameters param);

	/**
	 * 查询符合查询参数的实体结果集
	 * 
	 * @param param
	 * @return
	 */
	List<T> findResults(QueryParameters param);

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
