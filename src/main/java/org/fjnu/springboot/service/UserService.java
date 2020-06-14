package org.fjnu.springboot.service;

import org.fjnu.springboot.bean.User;
import org.fjnu.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-06-12 20:34
 */
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public List<User> SelectAll(){
        return userMapper.SelectAll();
    }

    public User SelectByUser(User user){
        return userMapper.SelectByUser(user);
    }


    public void InsertByUser(User user){
        userMapper.InsertByUser(user);
    }

    public void UpdateByusername(User user){
        userMapper.UpdateByusername(user);
    }
}
