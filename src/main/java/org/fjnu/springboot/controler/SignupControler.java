package org.fjnu.springboot.controler;

import org.apache.catalina.connector.Response;
import org.fjnu.springboot.bean.Mail;
import org.fjnu.springboot.bean.User;
import org.fjnu.springboot.service.UserService;
import org.fjnu.springboot.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

/**
 * @author wb_Lin
 * @create 2020-04-12 14:01
 */
@Controller
public class SignupControler {


    @Resource
    UserService userService;

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @RequestMapping("/user/signup")
    public String signup(@Valid Mail mail,Map<String,Object> map){
        Random random = new Random();
        int number=random.nextInt(10000)+1000 ;
        map.put("jihuoma",number);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("激活码通知");
        simpleMailMessage.setText("您的激活码为:"+number);
        simpleMailMessage.setTo(mail.getEmail());
        simpleMailMessage.setFrom("345504450@qq.com");
        javaMailSender.send(simpleMailMessage);
        return  "zhuce";
    }

    @RequestMapping("/signup")
    public String sign(HttpServletRequest request, HttpServletResponse response,Map<String,Object> map) throws ServletException, IOException {
        String jihuoma = request.getParameter("jihuoma");
        String code = request.getParameter("code");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(code.equals(jihuoma)&&username!=null&&password!=null){
            userService.InsertByUser(new User(username,MD5Utils.code(password)));
            return "index";
        }else if (code==null||username==null||password==null){
            map.put("msg","信息不能为空");
            map.put("jihuoma",jihuoma);
            return "zhuce";
        }else{
            map.put("msg","激活码错误");
            map.put("jihuoma",jihuoma);
            return "zhuce";
        }


    }
}
