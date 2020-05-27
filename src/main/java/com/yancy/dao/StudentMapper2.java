package com.yancy.dao;

import com.yancy.entity.Student;
import com.yancy.entity.Teacher2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * dao层数据操作、一对多
 */
public interface StudentMapper2 {
    public Teacher2 getTeachers(@Param("tid") int id); // 根据id查询Teacher2对象
    public Teacher2 getTeachers2(@Param("tid") int id);
}
