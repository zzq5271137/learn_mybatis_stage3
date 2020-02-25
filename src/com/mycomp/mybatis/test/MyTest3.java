package com.mycomp.mybatis.test;

import com.mycomp.mybatis.domain.Student;
import com.mycomp.mybatis.domain.Teacher;
import com.mycomp.mybatis.mapper.StudentMapper;
import com.mycomp.mybatis.mapper.TeacherMapper;
import com.mycomp.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest3 {

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getAllTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherByid(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Teacher teacher = new Teacher();
        teacher.setTeacher_name("新老师");

        Student student1 = new Student();
        student1.setStu_name("新学生1");
        Student student2 = new Student();
        student2.setStu_name("新学生2");

        teacher.getStudents().add(student1);
        teacher.getStudents().add(student2);

        // 保存老师
        teacherMapper.insertTeacher(teacher);
        // 保存学生
        studentMapper.insertStudent(student1);
        studentMapper.insertStudent(student2);
        // 插入关系表
        for (Student student : teacher.getStudents()) {
            teacherMapper.insertRel(teacher.getTeacher_id(), student.getStu_id());
        }

        sqlSession.commit();
        sqlSession.close();
    }

}
