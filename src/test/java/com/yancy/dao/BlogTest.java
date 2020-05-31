package com.yancy.dao;

import com.yancy.entity.Blog;
import com.yancy.entity.User;
import com.yancy.utils.IdUtil;
import com.yancy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogTest {
    @Test
    public void testInsert() {
        // 1 获取 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2 执行sql
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog b1 = new Blog();
        b1.setId(IdUtil.getId());
        b1.setAuthor("Yancy");
        b1.setCreateTime(new Date());
        b1.setTitle("第二篇博客");
        b1.setViews(0);
        int res = blogMapper.addBlog(b1);

        sqlSession.commit();    // 提交

        // 3 关闭session
        sqlSession.close();
    }

    @Test
    public void testSelect() {
        // 1 获取 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2 执行sql
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogs = blogMapper.selectAllBlogs();

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        // 3 关闭session
        sqlSession.close();
    }

    @Test
    public void testSelect2() {
        // 1 获取 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2 执行sql
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> conditionMap = new HashMap<String, Object>();   // 查询条件
//        conditionMap.put("views", 100);
        conditionMap.put("author", "Yancy");
        List<Blog> blogs = blogMapper.selectByAuthorAndViews(conditionMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        // 3 关闭session
        sqlSession.close();
    }

    @Test
    public void testSelectChoose() {
        // 1 获取 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2 执行sql
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> conditionMap = new HashMap<String, Object>();   // 查询条件
        conditionMap.put("views", 100);
//        conditionMap.put("author", "Yancy");
        List<Blog> blogs = blogMapper.selectByChoose(conditionMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        // 3 关闭session
        sqlSession.close();
    }

    /**
     * 测试foreach的动态sql
     */
    @Test
    public void testSelectForeach() {
        // 1 获取 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2 执行sql
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> conditionMap = new HashMap<String, Object>();   // 查询条件
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        conditionMap.put("ids", ids);

        List<Blog> blogs = blogMapper.selectByForeach(conditionMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        // 3 关闭session
        sqlSession.close();
    }
}
