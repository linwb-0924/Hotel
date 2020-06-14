package org.fjnu.springboot.service;

import org.fjnu.springboot.bean.Customer;
import org.fjnu.springboot.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-06-13 16:05
 */
@Service
public class CustomerService {

    @Resource
    CustomerMapper customerMapper;


    public List<Customer> SelectAll(){
        return customerMapper.SelectAll();
    }

    public Integer SelectByCount(){
        return customerMapper.SelectByCount();
    }

    public Customer SelectById(String cno){
        return customerMapper.SelectById(cno);
    }

    public void InsertByCustomer(Customer customer){
        customerMapper.InsertByCustomer(customer);
    }
}
