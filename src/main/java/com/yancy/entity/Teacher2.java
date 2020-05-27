package com.yancy.entity;

import java.util.List;

public class Teacher2 {
    private int id;
    private String name;

    // 一个老师有多个学生
    private List<Student2> students;

    @Override
    public String toString() {
        return "Teacher2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student2> getStudents() {
        return students;
    }

    public void setStudents(List<Student2> students) {
        this.students = students;
    }
}
