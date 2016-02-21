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
public abstract class AbstractEntityMapper<T extends IEntity, PK extends Serializable> implements IEntityMapper<T, PK> {

	protected SqlSessionFactory sqlSessionFactory;

	@Autowired
	@Qualifier("sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	protected abstract String namesapceForSqlId();

	protected String fullSqlId(String sqlId) {
		return namesapceForSqlId() + "." + sqlId;
	}

	@Override
	public List<T> page(QueryParameters queryParam) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectList(fullSqlId("page"), queryParam);
		}
	}

	@Override
	public int count(QueryParameters queryParam) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectOne(fullSqlId("count"), queryParam);
		}
	}

	@Override
	public T get(PK id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectOne(fullSqlId("get"), id);
		}
	}


	@Override
	public int insert(T t) {
		int count;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			count = session.insert(fullSqlId("insert"), t);
			session.commit(true);
		}
		return count;
	}

	@Override
	public int insertSelective(T t) {
		int count;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			count = session.insert(fullSqlId("insertSelective"), t);
			session.commit(true);
		}
		return count;
	}

	@Override
	public int update(T t) {
		int count = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			count = session.update(fullSqlId("update"), t);
			session.commit(true);
		}
		return count;
	}

	@Override
	public int updateSelective(T t) {
		int count = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			count = session.update(fullSqlId("updateSelective"), t);
			session.commit(true);
		}
		return count;
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

	/**
	 * 查询一个对象
	 * @param statement String 查询Id
	 * @param parameter Object 参数
	 * @return
	 */
	public <E> E selectOne(String statement, Object parameter) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectOne(fullSqlId(statement), parameter);
		}
	}

	/**
	 * 查询列表
	 * @param statement String 查询Id
	 * @param parameter Object 参数
	 * @return
	 */
	public <E> List<E> selectList(String statement, Object parameter) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectList(fullSqlId(statement), parameter);
		}
	}


}
