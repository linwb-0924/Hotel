package org.fjnu.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fjnu.springboot.bean.User;

import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-04-12 11:49
 */
@Mapper
public interface UserMapper {

     List<User> SelectAll();

     User SelectByUser(User user);


     void InsertByUser(User user);

     void UpdateByusername(User user);
}
