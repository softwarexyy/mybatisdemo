package com.yancy.dao;

import com.yancy.entity.Student;
import com.yancy.entity.User;
import com.yancy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {

    @Test
    public void testSelect() {
        // 1 获取 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2 执行sql
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.selectStudent();

        for (Student student : studentList) {
            System.out.println(student);
        }

        // 3 关闭session
        sqlSession.close();
    }

    @Test
    public void testSelect2() {
        // 1 获取 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2 执行sql
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.selectStudent2();

        for (Student student : studentList) {
            System.out.println(student);
        }

        // 3 关闭session
        sqlSession.close();
    }

}
