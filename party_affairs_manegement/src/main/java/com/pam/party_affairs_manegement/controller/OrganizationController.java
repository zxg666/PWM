package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.Organization;
import com.pam.party_affairs_manegement.mapper.OrganizationMapper;
import com.pam.party_affairs_manegement.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    //登录页的下拉框
    @RequestMapping("findAll")
    public String findAllOrganization(Model model){
        List<Organization> organizationList = this.organizationService.selectAll();
        System.out.println(organizationList);
        model.addAttribute("organizationList",organizationList);
        return "login";
    }

    //党组织管理
    @RequestMapping("organizationManagement")
    public String functionManagement(Model model){
        List<Organization> organizationList = this.organizationService.selectAll();
        model.addAttribute("organizationList",organizationList);
        System.out.println("organizationList:"+organizationList);
        return "basic/organization/organization_management";
    }


    //按组织名和领导查询
    @RequestMapping("organizationList")
    public String userList(Model model,String organizationName,String organizationLeader){
        Organization organizationList = this.organizationService.selectByName(organizationName,organizationLeader);
        model.addAttribute("organizationList",organizationList);
        System.out.println("organizationList:"+organizationList);
        return "basic/organization/organization_management";
    }

    //新增党组织
    @RequestMapping("add")
    public String add(Organization organization){
        Organization organization1 = this.organizationService.selectById(organization.getOrganizationId());
        if (organization1 == null){
            Organization organization2 = new Organization();
            String organizationName = organization.getOrganizationName();
            organization2.setOrganizationName(organizationName);
            String organizationLeader = organization.getOrganizationLeader();
            organization2.setOrganizationLeader(organizationLeader);
            String organizationInfo = organization.getOrganizationInfo();
            organization2.setOrganizationInfo(organizationInfo);
            Integer parentId = organization.getParentId();
            organization2.setParentId(parentId);
            String telephone = organization.getTelephone();
            organization2.setTelephone(telephone);
            organization2.setEntryTime(new Date());
            this.organizationService.insert(organization2);
            System.out.println(organization2);
            return "redirect:/organization/organizationManagement";
        }else{
            return "basic/organization/add";
        }
    }

    //修改党组织
    @RequestMapping("edit/{organizationId}")
    public String edit(@PathVariable("organizationId") Integer organizationId, Organization organization){
        Organization organization1 = new Organization();
        organization1.setOrganizationId(organizationId);
        String organizationName = organization.getOrganizationName();
        organization1.setOrganizationName(organizationName);
        String organizationLeader = organization.getOrganizationLeader();
        organization1.setOrganizationLeader(organizationLeader);
        String organizationInfo = organization.getOrganizationInfo();
        organization1.setOrganizationInfo(organizationInfo);
        Integer parentId = organization.getParentId();
        organization1.setParentId(parentId);
        String telephone = organization.getTelephone();
        organization1.setTelephone(telephone);
        this.organizationService.update(organization1);
        System.out.println("---------"+organization1);
        return "redirect:/organization/organizationManagement";
    }

    //删除党组织
    @RequestMapping("delete/{organizationId}")
    public String delete(@PathVariable("organizationId") Integer organizationId){
        Organization organization = this.organizationService.selectById(organizationId);
        System.out.println("organization"+organization);
        this.organizationService.delete(organizationId);
        return "redirect:/organization/organizationManagement";
    }
}
