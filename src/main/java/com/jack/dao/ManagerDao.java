package com.jack.dao;

import com.jack.pojo.Manager;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface ManagerDao {
    /**
     * 人事管理员登录
     * @return
     */
    @Select("select * from manager where username = #{username} and password = #{password}")
    public Manager selectManager(Map<String,Object> parameters);
}
