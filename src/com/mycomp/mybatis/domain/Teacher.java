package com.mycomp.mybatis.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Teacher {

    private Integer teacher_id;
    private String teacher_name;
    private List<Student> students = new ArrayList<>();

}
