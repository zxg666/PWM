package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.RoleFunction;
import com.pam.party_affairs_manegement.domain.UserRoleOrganization;
import com.pam.party_affairs_manegement.domain.Users;
import com.pam.party_affairs_manegement.service.RoleFunctionService;
import com.pam.party_affairs_manegement.service.UserRoleOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/function")
public class FunctionController {
    @Autowired
    private UserRoleOrganizationService userRoleOrganizationService;
    @Autowired
    private RoleFunctionService roleFunctionService;

    //一级功能及其子功能列表
    @RequestMapping("nav")
    public String nav(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        Integer userId = user.getUserId();
        String organization = (String) session.getAttribute("organization");
        UserRoleOrganization userRoleOrganization = this.userRoleOrganizationService.selectByOrganization(userId,organization);
        List<RoleFunction> roleFunction = this.roleFunctionService.selectByRole(userRoleOrganization.getRoleId());
        model.addAttribute("roleFunction",roleFunction);
        return "nav";
    }
}
