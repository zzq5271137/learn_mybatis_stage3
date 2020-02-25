package com.mycomp.mybatis.mapper;

import com.mycomp.mybatis.domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    // 采用左连接的方式, 查询所有老师, 并其把关联的所有学生也查出来
    List<Teacher> getAllTeachers();

    // 采用分步查询的方式, 根据id查询指定的老师
    Teacher getTeacherByid(Integer id);

    // 保存老师
    void insertTeacher(Teacher teacher);

    // 插入关系表
    void insertRel(@Param("teacher_id") Integer teacher_id, @Param("stu_id") Integer stu_id);
}
