package com.cll.dao;

import com.cll.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2020/8/20.
 */
public interface userdao {
     List<User> userMapper();
     void addUser(User u);
     User getUserByid(int id);
}
