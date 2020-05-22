package com.yancy.dao;

import com.yancy.entity.User;
import com.yancy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserTest {

    @Test
    public void test() {
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
}
