package org.fjnu.springboot.controler;

import org.fjnu.springboot.bean.User;
import org.fjnu.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author wb_Lin
 * @create 2020-06-13 15:50
 */
@Controller
public class CertificateControler {

    @Resource
    UserService userService;

    @GetMapping("/certification")
    public String certification(Model model, HttpServletRequest request){
        String msg = request.getParameter("msg");
        if(msg !=null){
            model.addAttribute("msg",msg);
        }
        return "renzheng";
    }
    @PostMapping("/certification")
    public String certificationn(@RequestParam String nickname, @RequestParam MultipartFile file, RedirectAttributes redirectAttributes, HttpSession session){
        if(file.isEmpty()){
            redirectAttributes.addAttribute("msg","文件上传失败");
            return "redirect:/certification";
        }
        if (nickname=="") {
            redirectAttributes.addAttribute("msg","姓名为空");
            return "redirect:/certification";
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        User user = (User) session.getAttribute("loginuser");
        String name1 = System.getProperty("user.dir")+"/src/main/resources/static/";
        String name2 = "images/"+user.getUsername()+suffixName;
        fileName = name1+name2;
        File dest = new File(fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
        }
        User user1 = new User(user.getUsername(), nickname, name2);
        userService.UpdateByusername(user1);
        session.setAttribute("loginuser",user1);
        return "redirect:/success";
    }
}
