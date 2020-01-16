package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.Organization;
import com.pam.party_affairs_manegement.mapper.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationMapper organizationMapper;

    @RequestMapping("findAll")
    public String findAllOrganization(Model model){
        List<Organization> organizationList = this.organizationMapper.selectAll();
        System.out.println(organizationList);
        model.addAttribute("organizationList",organizationList);
        return "login";
    }
}
