/*
 * Copyright (c) 2015 by XuanWu Wireless Technology Co., Ltd. 
 *             All rights reserved                         
 */
package com.newweb.common.persist;

import java.io.Serializable;
import java.util.List;

import com.newweb.common.domain.IEntity;
import com.newweb.common.util.QueryParameters;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


/**
 * 基于MyBatis的实体基本仓储的抽象实现
 * @author Jake
 * @Data 2016年1月17日
 * @Version 1.0.0
 */
public abstract class AbstractEntityMapper<T extends IEntity, PK extends Serializable> extends AbstractMapper<T> implements IEntityMapper<T, PK> {

	@Override
	public T get(PK id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectOne(fullSqlId("get"), id);
		}
	}

	@Override
	public int findResultCount(QueryParameters param) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectOne(fullSqlId("findResultCount"), param);
		}
	}

	@Override
	public List<T> findResults(QueryParameters param) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectList(fullSqlId("findResults"), param);
		}
	}

	@Override
	public void save(T t) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			int ret = 0;
			if (t.getId() != null) {
				ret = session.update(fullSqlId("update"), t);
			}
			if (ret == 0) {
				session.insert(fullSqlId("insert"), t);
			}
			session.commit(true);
		}
	}

	@Override
	public int delete(PK id) {
		int count;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			count = session.delete(fullSqlId("delete"), id);
			session.commit(true);
		}
		return count;
	}

}
