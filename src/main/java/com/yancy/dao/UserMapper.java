package com.yancy.dao;

import com.yancy.entity.User;
import java.util.List;

/**
 * dao层数据操作
 */
public interface UserMapper {
    public List<User> selectUser();
}
