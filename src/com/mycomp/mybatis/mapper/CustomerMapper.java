package com.mycomp.mybatis.mapper;

import com.mycomp.mybatis.domain.Customer;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {

    // 输出简单类型(查询总数)
    Integer getCount();

    // 输出对象, (根据id获取用户)
    Customer getCustomerByIdCust(Integer id);

    // 输出Map类型, 方式一, (根据id获取用户)
    Map<String, Object> getCustomerByIdMap(Integer id);

    // 输出Map类型, 方式二, 以cust_id为Map的key, (获取所有的用户)
    @MapKey("cust_id")
    Map<Integer, Customer> getAllCustomerCase1();

    // 输出Map类型, 方式二, 以cust_name为Map的key, (获取所有的用户)
    @MapKey("cust_name")
    Map<String, Customer> getAllCustomerCase2();

    // 插入一条客户信息
    void insertCustomer(Customer customer);

    // 采用左连接的方式, 查询所有的用户, 并查询出其相关联的订单
    List<Customer> getAllCustomers1();

    // 采用分步查询的方式, 查询所有的用户, 并查询出其相关联的订单
    List<Customer> getAllCustomers2();
}
