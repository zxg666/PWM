package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.Function;
import com.pam.party_affairs_manegement.domain.Users;
import com.pam.party_affairs_manegement.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private FunctionService functionService;

     //跳转到首页
    @RequestMapping("index")
    //, @RequestParam("userId") Integer userId
    public String index(Model model){
        List<Function> hotFunction = this.functionService.selectAllByVisit();
        model.addAttribute("hotFunction",hotFunction);
        System.out.println(hotFunction);
        return "index";
    }
    //跳转到主页面
    @RequestMapping("main")
    public String main(){
        return "main";
    }
    //跳转到登录页
    @RequestMapping("login")
    public  String login(){
        return "login";
    }
}
