package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.Apply;
import com.pam.party_affairs_manegement.service.ApplyService;
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
}
