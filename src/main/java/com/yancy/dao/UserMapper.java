package com.yancy.dao;

import com.yancy.entity.User;
import java.util.List;
import java.util.Map;

/**
 * dao层数据操作
 */
public interface UserMapper {
    public List<User> selectUser();
    public int addUser(User user);
    public int addUserByMap(Map<String, Object> map);   // 使用map传递参数
    public List<User> selectUserByLike(String paramForName);   // 根据param模糊查询姓名
    public List<User> selectUserByLimit(Map<String, Integer> map);  // 使用limit语句分页

    public User testOneCache(int id);     // 测试一级缓存（根据id查User）
}
