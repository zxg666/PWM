package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.RoleFunction;
import com.pam.party_affairs_manegement.domain.UserRoleOrganization;
import com.pam.party_affairs_manegement.domain.Users;
import com.pam.party_affairs_manegement.service.RoleFunctionService;
import com.pam.party_affairs_manegement.service.UserRoleOrganizationService;
import com.pam.party_affairs_manegement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleFunctionService roleFunctionService;
    @Autowired
    private UserRoleOrganizationService userRoleOrganizationService;

     //跳转到首页
    @RequestMapping("index")
    public String index(Model model, @RequestParam("userId") Integer userId,
                        @RequestParam("organization") String organization){
        //展示用户信息
        Users user = this.userService.selectById(userId);
        model.addAttribute("user",user);
        System.out.println("user:"+user);
        //按权限查出功能菜单
        UserRoleOrganization userRoleOrganization = this.userRoleOrganizationService.selectByOrganization(userId,organization);
        List<RoleFunction> roleFunction = this.roleFunctionService.selectByRole(userRoleOrganization.getRoleId());
        System.out.println("roleFunction:"+roleFunction);
        model.addAttribute("roleFunction",roleFunction);
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
        return "system/user/login";
    }
    //跳转到表单页
    @RequestMapping("form")
    public String form(){
        return "form";
    }
    //跳转到表格页
    @RequestMapping("table")
    public String table(){
        return "table";
    }
    //跳转到首页
    @RequestMapping("home")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        Integer userId = user.getUserId();
        String organization = (String) session.getAttribute("organization");
        //按热度展示12个功能
        UserRoleOrganization userRoleOrganization = this.userRoleOrganizationService.selectByOrganization(userId,organization);
        List<RoleFunction> hotFunction = this.roleFunctionService.selectByVisit(userRoleOrganization.getRoleId());
        System.out.println("hotFunction:"+hotFunction);
        model.addAttribute("hotFunction",hotFunction);
        return "home";
    }
    //跳转到工作页
    @RequestMapping("work")
    public String work(){
        return "service/work";
    }
}
