package com.mycomp.mybatis.mapper;

import com.mycomp.mybatis.domain.Customer;
import org.apache.ibatis.annotations.MapKey;

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

}
