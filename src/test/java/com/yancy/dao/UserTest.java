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

    @Test
    public void testSelectByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 2);
        map.put("pageSize", 2);
        List<User> users = userMapper.selectUserByLimit(map);

        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    /**
     * 测试一级缓存
     */
    @Test
    public void testOneCache(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("测试一级缓存： ");
        User user = userMapper.testOneCache(1);
        System.out.println(user);

        // 如果两次相同之间有任何update/insert操作，则第二次查询不会使用一级缓存
//        userMapper.addUser(new User("hello1", 12));

        System.out.println("--------------------");
        User user1 = userMapper.testOneCache(1);
        System.out.println(user1);

        System.out.println("--------------------");
        User user2 = userMapper.testOneCache(1);
        System.out.println(user2);

        sqlSession.close();

        // 以下测试二级缓存
        System.out.println("测试二级缓存： ");
        // sqlSession关闭后，重新开启sqlSession，此时一级缓存已消失，内容移至二级缓存，故以下命中二级缓存
        sqlSession = MybatisUtils.getSqlSession();  // 重新获取sqlsession
        userMapper = sqlSession.getMapper(UserMapper.class);
        User user3 = userMapper.testOneCache(1);
        System.out.println(user3);
        sqlSession.close();

    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testTwoCache() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("第一次查询：");
        User user = userMapper.testTwoCache(1);
        System.out.println(user);
        sqlSession.close();

        /**
         * （1）二级缓存作用域是一个namespace
         * （2）sqlSession关闭后，一级缓存中的内容会转移到二级缓存中
         */
        System.out.println("第二次查询：");
        sqlSession = MybatisUtils.getSqlSession();  // 重新获取sqlsession
        userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.testTwoCache(1);
        System.out.println(user1);
        sqlSession.close();

        System.out.println("第三次查询：");
        sqlSession = MybatisUtils.getSqlSession();  // 重新获取sqlsession
        userMapper = sqlSession.getMapper(UserMapper.class);
        User user2 = userMapper.testTwoCache(1);
        System.out.println(user1);
        sqlSession.close();
    }
}
