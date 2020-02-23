package com.mycomp.mybatis.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {

    private Integer order_id;
    private String order_name;
    private String order_num;
    private Customer customer;

}
