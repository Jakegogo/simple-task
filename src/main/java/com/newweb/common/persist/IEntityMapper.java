package com.newweb.common.persist;

import com.newweb.common.domain.IEntity;
import com.newweb.common.util.QueryParameters;

import java.io.Serializable;
import java.util.List;


/**
 * 仓储访问接口, 提供通用实体仓储方法
 * @author Jake
 * @Data 2016年1月17日
 * @Version 1.0.0
 */
public interface IEntityMapper<T extends IEntity, PK extends Serializable> extends IMapper <T> {

	/**
	 * 分页
	 * @param queryParam 分页查询参数
	 * @return
     */
	List<T> page(QueryParameters queryParam);

	/**
	 * 根据实体ID，查找实体
	 * 
	 * @param id
	 * @return
	 */
	T get(PK id);

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

}
