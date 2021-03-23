package com.jack.controller;

import com.jack.pojo.Manager;
import com.jack.service.DepartmentService;
import com.jack.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ManagerController {
    @Autowired
    @Qualifier("managerServiceImpl")
    private ManagerService managerService;

    /**
     * 人事管理员登录
     * @param model
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String password, Model model, HttpSession session){
        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setPassword(password);
        boolean isLogin = managerService.login(manager);
        if(isLogin){
            //登录前先清楚所有session
            session.removeAttribute("username");

            //存入新的session
            session.setAttribute("username",username);
            model.addAttribute("msg","登录成功！");
            return "redirect:/selectAllDepartmentByPage";
        }
        else{
            model.addAttribute("msg","用户名或者密码错误，请检查!");
            return "pages/admin-login";
        }
    }

    /**
     * 认识管理员注销
     * @param model
     * @return
     */
    @RequestMapping("quit")
    public String quit(Model model, HttpSession session){
        session.removeAttribute("username");
        return "pages/admin-login";
    }
}
