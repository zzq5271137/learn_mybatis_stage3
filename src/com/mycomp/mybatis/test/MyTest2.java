package com.mycomp.mybatis.test;

import com.mycomp.mybatis.domain.Customer;
import com.mycomp.mybatis.domain.Order;
import com.mycomp.mybatis.mapper.CustomerMapper;
import com.mycomp.mybatis.mapper.OrderMapper;
import com.mycomp.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest2 {

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> allOrders = mapper.getAllOrders();
        for (Order order : allOrders) {
            System.out.println(order);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.getOrderById(3);
        System.out.println(order);
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        Order order = new Order();
        order.setOrder_name("新订单001");
        order.setOrder_num("20200223");

        Customer customer = new Customer();
        customer.setCust_name("新客户001");
        customer.setCust_phone("13912004862");
        customer.setEmail("zzq@gmail.com");
        customer.setCust_profession("废物");

        order.setCustomer(customer);

        // 应该先保存客户, 然后获取保存客户生成的id, 再去保存订单
        customerMapper.insertCustomer(customer);
        orderMapper.insertOrder(order);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.getAllCustomers1();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.getAllCustomers2();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    @Test
    public void test6() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        Customer customer = new Customer();
        customer.setCust_name("zzq");

        Order order1 = new Order();
        order1.setOrder_name("新订单1");
        Order order2 = new Order();
        order2.setOrder_name("新订单2");

        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        // 保存数据
        customerMapper.insertCustomer(customer);
        orderMapper.insertOrder(order1);
        orderMapper.insertOrder(order2);

        // 更新关系
        for (Order order : customer.getOrders()) {
            orderMapper.updateOrderCustId(order.getOrder_id(), customer.getCust_id());
        }

        sqlSession.commit();
        sqlSession.close();
    }

}
