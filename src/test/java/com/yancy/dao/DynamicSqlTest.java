package com.yancy.dao;

import com.yancy.utils.IdUtil;
import org.junit.Test;

public class DynamicSqlTest {

    @Test
    public void testGetId() {
        System.out.println(IdUtil.getId());
    }
}
