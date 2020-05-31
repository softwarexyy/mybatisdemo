package com.yancy.dao;

import com.yancy.entity.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    public int addBlog(Blog blog);
    public List<Blog> selectAllBlogs();
    public List<Blog> selectByAuthorAndViews(Map<String, Object> condition);    // 测试if动态sql
    public List<Blog> selectByChoose(Map<String, Object> condition);    // 测试choose/when动态SQL
    public List<Blog> selectByForeach(Map<String, Object> condition);   // 测试foreach动态sql
}
