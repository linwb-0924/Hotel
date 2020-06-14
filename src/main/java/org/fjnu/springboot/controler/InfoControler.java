package org.fjnu.springboot.controler;

import com.github.pagehelper.PageHelper;
import org.fjnu.springboot.bean.Customer;
import org.fjnu.springboot.bean.Information;
import org.fjnu.springboot.bean.Room;
import org.fjnu.springboot.service.CustomerService;
import org.fjnu.springboot.service.InfoService;
import org.fjnu.springboot.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-06-13 16:21
 */
@Controller
public class InfoControler {

    @Resource
    InfoService infoService;

    @Resource
    RoomService roomService;

    @Resource
    CustomerService customerService;

    @GetMapping("/searchinfo")
    public String selectroom(Model model, HttpServletRequest request){
        String pagenum =request.getParameter("pagenum") ;
        String msg = request.getParameter("msg");
        if(msg !=null){
            model.addAttribute("msg",msg);
        }
        Integer totalpage = infoService.SelectByCount()%3==0 ? (infoService.SelectByCount()/3) : (infoService.SelectByCount()/3)+1;
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
        List<Information> informations = infoService.SelectAll();
        model.addAttribute("informations",informations);
        return "select-info";
    }
    @PostMapping("/searchinfo")
    public String  searchone(@RequestParam String query, Model model){
        if(query==""){
            return "redirect:/searchinfo";
        }
        Information information = infoService.SelectById(query);
        model.addAttribute("informations",information);
        return "info-one";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("rooms",roomService.SelectByEmpty());
        return "create-info";
    }
    @PostMapping("/createinfo")
    public String createinfo(@RequestParam String cname, @RequestParam String cno, @RequestParam String telephone, @RequestParam String rno, @RequestParam String deposit, RedirectAttributes redirectAttributes){
        if(cno==""){
            redirectAttributes.addAttribute("msg","新增失败，身份证号为空");
            return "redirect:/searchinfo";
        }
        if(cname==""){
            redirectAttributes.addAttribute("msg","新增失败，姓名为空");
            return "redirect:/searchinfo";
        }
        if(telephone==""){
            redirectAttributes.addAttribute("msg","新增失败，电话号码为空");
            return "redirect:/searchinfo";
        }
        if(rno==""){
            redirectAttributes.addAttribute("msg","新增失败，房间号为空");
            return "redirect:/searchinfo";
        }
        if(deposit==""){
            redirectAttributes.addAttribute("msg","新增失败，押金为空");
            return "redirect:/searchinfo";
        }
        double price;
        try {
            price = Double.parseDouble(deposit);
        }catch (Exception e){
            redirectAttributes.addAttribute("msg","新增失败，押金填写错误");
            return "redirect:/searchinfo";
        }
        infoService.InsertByInformation(new Information(cno,rno,new Date(),price));
        customerService.InsertByCustomer(new Customer(cno,cname,telephone));
        roomService.UpdateByRno(rno);
        return "redirect:/searchinfo";
    }
}
