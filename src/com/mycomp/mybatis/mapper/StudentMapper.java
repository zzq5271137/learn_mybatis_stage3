package com.mycomp.mybatis.mapper;

import com.mycomp.mybatis.domain.Student;

import java.util.List;

public interface StudentMapper {

    // 根据老师id的集合查询学生
    List<Student> getStusByTeacherIdCollection(Integer id);

    // 保存学生
    void insertStudent(Student student);

}
