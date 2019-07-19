package com.demo.mybatis.test;
import com.demo.mybatis.bean.Employee;
import com.demo.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    /**
     * 创建 SqlSessionFactory 对象
     * @return SqlSessionFactory 对象
     * @throws IOException
     */
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String rosource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(rosource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory;
    }

    /**
     * 两级缓存：
     * 一级缓存（本地缓存）：sqlsession级别的缓存，一级缓存是一直开启的：
     *      与数据库
     */
    @Test
    public void testFirstLevelCache() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp = mapper.getEmployeeById(1);

            System.out.println(emp);

            Employee emp2 = mapper.getEmployeeById(1);
            System.out.println(emp2);

            System.out.println(emp == emp2);
        }finally {
            sqlSession.close();
        }


    }
}
