package com.yancy.dao;

import com.yancy.entity.Student;

import java.util.List;

/**
 * dao层数据操作
 */
public interface StudentMapper {
    public List<Student> selectStudent();
    public List<Student> selectStudent2();
}
