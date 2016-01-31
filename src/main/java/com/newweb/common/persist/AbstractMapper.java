package com.newweb.common.persist;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 基于MyBatis的抽象实现
 * Created by Jake on 1/31 0031.
 */
public abstract class AbstractMapper<T> implements IMapper<T> {

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

}
