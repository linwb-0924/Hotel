package org.fjnu.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fjnu.springboot.bean.Customer;
import org.fjnu.springboot.bean.Information;

import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-06-13 10:01
 */
@Mapper
public interface InfoMapper {

    List<Information> SelectAll();

    Integer SelectByCount();

    Information SelectById(String cno);

    void InsertByInformation(Information information);
}
