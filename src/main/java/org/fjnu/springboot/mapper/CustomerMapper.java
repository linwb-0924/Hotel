package org.fjnu.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fjnu.springboot.bean.Customer;
import org.fjnu.springboot.bean.Room;

import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-06-13 10:01
 */
@Mapper
public interface CustomerMapper {

    List<Customer> SelectAll();

    Integer SelectByCount();

    Customer SelectById(String cno);

    void InsertByCustomer(Customer customer);
}
