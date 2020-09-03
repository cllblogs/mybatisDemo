package com.cll.dao;

import com.cll.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/8/20.
 */
public interface userdao {
    List<User> userMapper();

    void addUser(@Param("c") User u);

    User getUserByid(int id);

    void updateUserByid(@Param("id") int ids, @Param("name") String name, @Param("pass") String password);


    List<User> listUser(@Param("c") List<Integer> e);



}
