package com.imooc.oa.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;

    // SqlSessionFactory Instantiate
    static {
        Reader r = null;
        try {
            r = Resources.getResourceAsReader("myBatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(r);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Run SQL Select
     * @param func SQL Select Command
     * @return Result
     */
    public static Object executeQuery(Function<SqlSession, Object> func) {
        SqlSession s = sqlSessionFactory.openSession();
        try {
            Object obj = func.apply(s);
            return obj;
        } catch (RuntimeException e){
          s.rollback();
          throw e;
        } finally {
            s.close();
        }
    }

    /**
     * Run SQL Update
     * @param func SQL Update Command
     * @return Result
     */
    public static Object executeUpdate(Function<SqlSession, Object> func) {
        SqlSession s = sqlSessionFactory.openSession(false);
        try {
            Object obj = func.apply(s);
            s.commit();
            return obj;
        } catch (RuntimeException e){
            s.rollback();
            throw e;
        } finally {
            s.close();
        }
    }
}
