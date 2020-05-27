package com.yancy.dao;

import com.yancy.entity.Student;
import com.yancy.entity.Teacher;
import com.yancy.entity.Teacher2;
import com.yancy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentTest2 {

    @Test
    public void testSelect() {
        // 1 获取 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2 执行sql
        StudentMapper2 studentMapper2 = sqlSession.getMapper(StudentMapper2.class);
        Teacher2 teacher = studentMapper2.getTeachers(1);

        System.out.println(teacher);

        // 3 关闭session
        sqlSession.close();
    }

    @Test
    public void testSelect2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper2 mapper = sqlSession.getMapper(StudentMapper2.class);

        Teacher2 t2 = mapper.getTeachers2(1);
        System.out.println(t2);

        sqlSession.close();
    }

}
