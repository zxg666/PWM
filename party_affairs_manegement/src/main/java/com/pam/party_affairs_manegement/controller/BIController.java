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
@RequestMapping("/BI")
public class BIController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApplyService applyService;

    //查找全部党员
    @RequestMapping("memberManagement")
    public String memberManagement(Model model){
        List<Users> userList = this.userService.selectByMember();
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "basic/member/member_management";
    }

    //模糊查找全部党员
    @RequestMapping("memberList")
    public String memberList(Model model,String userName){
        List<Users> userList = this.userService.selectLikeByMember(userName);
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "basic/member/member_management";
    }

    //查找全部积极分子
    @RequestMapping("activistManagement")
    public String activistManagement(Model model){
        List<Users> userList = this.userService.selectByActivist();
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "basic/activist/activist_management";
    }

    //模糊查找全部积极分子
    @RequestMapping("activistList")
    public String activistList(Model model,String userName){
        List<Users> userList = this.userService.selectLikeByActivist(userName);
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "basic/activist/activist_management";
    }

    //查找全部流动党员
    @RequestMapping("flowManagement")
    public String flowManagement(Model model){
        List<Users> userList = this.userService.selectByFlow();
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "basic/flow/flow_management";
    }

    //模糊查找流动党员
    @RequestMapping("flowList")
    public String flowList(Model model,String userName){
        List<Users> userList = this.userService.selectLikeByFlow(userName);
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "basic/flow/flow_management";
    }

    //查找全部入党申请人
    @RequestMapping("applyManagement")
    public String applyManagement(Model model){
        List<Apply> applyList = this.applyService.selectAll();
        model.addAttribute("applyList",applyList);
        System.out.println("applyList:"+applyList);
        return "basic/apply/apply_management";
    }

    //模糊查找入党申请人
    @RequestMapping("applyList")
    public String applyList(Model model,String eopName,String title){
        List<Apply> applyList = this.applyService.selectByNameAndTitle(eopName,title);
        model.addAttribute("applyList",applyList);
        System.out.println("applyList:"+applyList);
        return "basic/apply/apply_management";
    }
}
