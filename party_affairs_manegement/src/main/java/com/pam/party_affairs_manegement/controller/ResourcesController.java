package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.Apply;
import com.pam.party_affairs_manegement.domain.Users;
import com.pam.party_affairs_manegement.service.ApplyService;
import com.pam.party_affairs_manegement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/resources")
public class ResourcesController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private UserService userService;

    //历史信息
    @RequestMapping("history")
    public String memberManagement(Model model){
        List<Apply> applyList = this.applyService.selectAll();
        model.addAttribute("applyList",applyList);
        System.out.println("applyList:"+applyList);
        return "resources/history/history";
    }

    //证明信
    @RequestMapping("certificate")
    public String memberList(Model model,String eopName,String title){
        List<Apply> applyList = this.applyService.selectByNameAndTitle(eopName,title);
        model.addAttribute("applyList",applyList);
        System.out.println("applyList:"+applyList);
        return "resources/certificate/certificate";
    }

    //介绍信
    @RequestMapping("letter")
    public String activistManagement(Model model){
        List<Users> userList = this.userService.selectByActivist();
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "resources/letter/letter";
    }

    //警示信息
    @RequestMapping("warning")
    public String activistList(Model model,String userName){
        List<Users> userList = this.userService.selectLikeByActivist(userName);
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "resources/warning/warning";
    }

    //新闻活动信息
    @RequestMapping("news")
    public String flowManagement(Model model){
        List<Users> userList = this.userService.selectByFlow();
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "resources/news/news";
    }
}
