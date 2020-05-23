package com.yancy.dao;

import com.yancy.entity.User;
import com.yancy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {

    @Test
    public void testSelect() {
        // 1 获取 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2 执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectUser();

        for (User user : userList) {
            System.out.println(user);
        }

        // 3 关闭session
        sqlSession.close();
    }

    @Test
    public void testSelect2() {
        // 1 获取 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2 执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectUserByLike("测试");

        for (User user : userList) {
            System.out.println(user);
        }

        // 3 关闭session
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User("Tester", 28);
        int count = userMapper.addUser(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertByMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", "mapYancy");
        map.put("userAge", 19);
        userMapper.addUserByMap(map);

        sqlSession.commit();
        sqlSession.close();
    }

}
