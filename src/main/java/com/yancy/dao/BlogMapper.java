package com.yancy.dao;

import com.yancy.entity.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    public int addBlog(Blog blog);
    public List<Blog> selectAllBlogs();
    public List<Blog> selectByAuthorAndViews(Map<String, Object> condition);
    public List<Blog> selectByChoose(Map<String, Object> condition);
}
