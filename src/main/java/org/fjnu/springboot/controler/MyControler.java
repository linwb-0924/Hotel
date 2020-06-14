package org.fjnu.springboot.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wb_Lin
 * @create 2020-04-12 11:42
 */
@Controller
public class MyControler {

    @RequestMapping("/")
    public String login(){
        return "index";
    }

    @RequestMapping("/zhuce")
    public String zhuce(){
        return "mail";
    }

}
