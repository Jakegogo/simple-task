/**
 * @filename IAssembler.java
 * @description  
 * @version 1.0
 * @author qye.zheng
 */
package com.newweb.common.assembler;

import com.newweb.common.exception.RelectAutoWorkException;
import com.newweb.common.util.GenericsUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 领域模型和视图模型转换抽象类
 */
public abstract class AbstractAssembler<D, E> {

	private transient Class<D> dtoClass;
	private transient Class<E> entityClass;

	protected AbstractAssembler() {
		dtoClass = GenericsUtils.getSuperClassGenricType(this.getClass(), 0);
		entityClass = GenericsUtils.getSuperClassGenricType(this.getClass(), 1);
	}

	/**
	 * 业务对象转成DTO
	 * @param e 业务对象
	 * @return DTO
	 */
	public D toDTO(E e) {
		D dto;
		try {
			dto = dtoClass.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
			throw new RelectAutoWorkException("无法初始化Dto实例:[" + dtoClass.getName() + "]", e1);
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			throw new RelectAutoWorkException("无法初始化Dto实例:[" + dtoClass.getName() + "]", e1);
		}
		BeanUtils.copyProperties(e, dto);
		return dto;
	}

	/**
	 * 业务对象批量转成DTO
	 * @param es 业务对象集合
	 * @return DTO集合，如果源业务对象集合为空或NULL，将返回空集合Collections.emptyList()
	 * @see Collections#emptyList
	 */
	public Collection<D> toDTOs(final Collection<E> es) {
		if (es == null || es.isEmpty()) {
			return Collections.emptyList();
		}
		Collection<D> ds = new ArrayList<D>();
		for (E e : es) {
			ds.add(toDTO(e));
		}
		return ds;
	}

	/**
	 * DTO转成业务对象
	 * @param d DTO
	 * @return 业务对象
	 */
	public E toEntity(final D d){
		E entity;
		try {
			entity = entityClass.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
			throw new RelectAutoWorkException("无法初始化Entity实例:[" + entityClass.getName() + "]", e1);
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			throw new RelectAutoWorkException("无法初始化Entity实例:[" + entityClass.getName() + "]", e1);
		}
		BeanUtils.copyProperties(d, entity);
		return entity;
	}

	/**
	 * 业务对象批量转成DTO
	 * @param ds DTO集合
	 * @return 业务对象集合，如果源DTO集合为空或NULL，将返回空集合Collections.emptyList()
	 * @see Collections#emptyList
	 */
	public Collection<E> toEntities(final Collection<D> ds) {
		if (ds == null || ds.isEmpty()) {
			return Collections.emptyList();
		}
		Collection<E> es = new ArrayList<E>();
		for (D d : ds) {
			es.add(toEntity(d));
		}
		return es;
	}
}
