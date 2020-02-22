package com.mycomp.mybatis.test;

import com.mycomp.mybatis.domain.Customer;
import com.mycomp.mybatis.mapper.CustomerMapper;
import com.mycomp.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Map;

public class MyTest {

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomerByIdCust(1);
        System.out.println(customer);
        sqlSession.close();
    }


    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<String, Object> customer = mapper.getCustomerByIdMap(1);
        System.out.println(customer);
        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<Integer, Customer> allCustomer = mapper.getAllCustomerCase1();
        for (Map.Entry<Integer, Customer> entry : allCustomer.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        sqlSession.close();
    }

    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<String, Customer> allCustomer = mapper.getAllCustomerCase2();
        for (Map.Entry<String, Customer> entry : allCustomer.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        sqlSession.close();
    }

}
