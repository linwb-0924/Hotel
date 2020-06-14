package org.fjnu.springboot.controler;

import com.github.pagehelper.PageHelper;
import org.fjnu.springboot.bean.Customer;
import org.fjnu.springboot.bean.Information;
import org.fjnu.springboot.bean.Room;
import org.fjnu.springboot.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-06-13 16:07
 */
@Controller
public class CustomerControler {

    @Resource
    CustomerService customerService;

    @GetMapping("/searchcustomer")
    public String selectroom(Model model, HttpServletRequest request){
        String pagenum =request.getParameter("pagenum") ;
        Integer totalpage = customerService.SelectByCount()%3==0 ? (customerService.SelectByCount()/3) : (customerService.SelectByCount()/3)+1;
        if(pagenum !=null){
            if(Integer.parseInt(pagenum)==0){
                PageHelper.startPage(totalpage, 3);
                model.addAttribute("pagenum",totalpage);
            }else if(Integer.parseInt(pagenum)==totalpage+1){
                PageHelper.startPage(1, 3);
                model.addAttribute("pagenum",1);
            }else{
                PageHelper.startPage(Integer.parseInt(pagenum), 3);
                model.addAttribute("pagenum",Integer.parseInt(pagenum));
            }

        }else{
            PageHelper.startPage(1, 3);
            model.addAttribute("pagenum",1);
        }
        List<Customer> customers = customerService.SelectAll();
        model.addAttribute("customers",customers);
        return "select-customer";
    }
    @PostMapping("/searchcustomer")
    public String  searchone(@RequestParam String query, Model model){
        if(query==""){
            return "redirect:/searchcustomer";
        }
        Customer customers = customerService.SelectById(query);
        model.addAttribute("customers",customers);
        return "customer-one";
    }
}
