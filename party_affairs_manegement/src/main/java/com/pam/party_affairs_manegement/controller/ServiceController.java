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
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private UserService userService;

    //党员申请名单
    @RequestMapping("memberManagement")
    public String memberManagement(Model model){
        List<Apply> applyList = this.applyService.selectAll();
        model.addAttribute("applyList",applyList);
        System.out.println("applyList:"+applyList);
        return "service/member/member_management";
    }

    //模糊查询党员申请名单
    @RequestMapping("memberList")
    public String memberList(Model model,String eopName,String title){
        List<Apply> applyList = this.applyService.selectByNameAndTitle(eopName,title);
        model.addAttribute("applyList",applyList);
        System.out.println("applyList:"+applyList);
        return "service/member/member_management";
    }

    //查找全部积极分子
    @RequestMapping("activistManagement")
    public String activistManagement(Model model){
        List<Users> userList = this.userService.selectByActivist();
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "service/activist/activist_management";
    }

    //模糊查找全部积极分子
    @RequestMapping("activistList")
    public String activistList(Model model,String userName){
        List<Users> userList = this.userService.selectLikeByActivist(userName);
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "service/activist/activist_management";
    }

    //查找全部流动党员
    @RequestMapping("flowManagement")
    public String flowManagement(Model model){
        List<Users> userList = this.userService.selectByFlow();
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "service/flow/flow_management";
    }

    //模糊查找流动党员
    @RequestMapping("flowList")
    public String flowList(Model model,String userName){
        List<Users> userList = this.userService.selectLikeByFlow(userName);
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "service/flow/flow_management";
    }


    //入党申请人审批
    @RequestMapping("applyEdit")
    public String applyEdit(String telephone,String telephone1){

        return "redirect:/service/memberManagement";
    }

    //缴费情况
    @RequestMapping("fareManagement")
    public String fareManagement(){
        return "/service/member/fare_management";
    }

    //领导成员管理
    @RequestMapping("leaderManagement")
    public String leaderManagement(Model model){
        List<Users> userList = this.userService.selectByMember();
        model.addAttribute("userList",userList);
        System.out.println("userList:"+userList);
        return "service/leader/leader_Management";
    }
}
