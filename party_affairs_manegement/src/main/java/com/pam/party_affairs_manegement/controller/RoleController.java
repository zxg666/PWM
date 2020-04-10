package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.Role;
import com.pam.party_affairs_manegement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    //角色管理
    @RequestMapping("roleManagement")
    public String roleManagement(Model model){
        List<Role> roleList = this.roleService.selectAll();
        model.addAttribute("roleList",roleList);
        System.out.println("roleList:"+roleList);
        return "system/role/role_management";
    }

    //按角色查询角色记录
    @RequestMapping("roleList")
    public String roleList(Model model,String role){
        Role roleRecord = this.roleService.selectByName(role);
        model.addAttribute("roleList",roleRecord);
        System.out.println("roleRecord:"+roleRecord);
        return "system/role/role_management";
    }

    //新增角色
    @RequestMapping("add")
    public String add(Role role){
        Role role1 = this.roleService.selectByName(role.getRole());
        if (role1 == null){
            Role role2 = new Role();
            String roleName = role.getRole();
            role2.setRole(roleName);
            String description = role.getDescription();
            role2.setDescription(description);
            role2.setStatus("有效");
            this.roleService.insert(role2);
            System.out.println("新增角色---------"+role2);
            return "redirect:/role/roleManagement";
        }else{
            return "system/role/role_management";
        }
    }

    //修改角色
    @RequestMapping("edit/{roleId}")
    public String edit(@PathVariable("roleId") Integer roleId,Role role){
        Role role1 = new Role();
        role1.setRoleId(roleId);
        String roleName = role.getRole();
        role1.setRole(roleName);
        String description = role.getDescription();
        role1.setDescription(description);
        String status = role.getStatus();
        role1.setStatus(status);
        this.roleService.update(role1);
        System.out.println("修改角色---------"+role1);
        return "redirect:/role/roleManagement";
    }

    //删除用户
    @RequestMapping("delete/{roleId}")
    public String delete(@PathVariable("roleId") Integer roleId){
        this.roleService.delete(roleId);
        return "redirect:/role/roleManagement";
    }
}
