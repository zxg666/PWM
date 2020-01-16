package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.Function;
import com.pam.party_affairs_manegement.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/function")
public class FunctionController {
    @Autowired
    private FunctionService functionService;

    //一级功能及其子功能列表
    @RequestMapping("nav")
    public String nav(Model model,Integer level, String organization){
        List<Function> functionList = this.functionService.selectByLevel(1);
        model.addAttribute("functionList",functionList);
        System.out.println(functionList);
        return "nav";
    }

    //按热度展示15个功能
    @RequestMapping("nav_index")
    public String navIndex(Model model, @RequestParam("organization") String organization){
        List<Function> hotFunction = this.functionService.selectAllByVisit();
        model.addAttribute("hotFunction",hotFunction);
        return "index";
    }
}
