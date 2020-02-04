package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.RoleFunction;
import com.pam.party_affairs_manegement.domain.UserRoleOrganization;
import com.pam.party_affairs_manegement.service.RoleFunctionService;
import com.pam.party_affairs_manegement.service.UserRoleOrganizationService;
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
    private RoleFunctionService roleFunctionService;
    @Autowired
    private UserRoleOrganizationService userRoleOrganizationService;

     //跳转到首页
    @RequestMapping("index")
    public String index(Model model, @RequestParam("userId") Integer userId,
                        @RequestParam("organization") String organization){
        //按热度展示15个功能
        UserRoleOrganization userRoleOrganization = this.userRoleOrganizationService.selectByOrganization(userId,organization);
        List<RoleFunction> roleFunction = this.roleFunctionService.selectByVisit(userRoleOrganization.getRoleId());
        System.out.println("hotFunction:"+roleFunction);
        model.addAttribute("hotFunction",roleFunction);
        model.addAttribute("userId",userId);
        model.addAttribute("organization",organization);
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
