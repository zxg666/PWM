package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.*;
import com.pam.party_affairs_manegement.service.FunctionService;
import com.pam.party_affairs_manegement.service.RoleFunctionService;
import com.pam.party_affairs_manegement.service.UserRoleOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/function")
public class FunctionController {
    @Autowired
    private UserRoleOrganizationService userRoleOrganizationService;
    @Autowired
    private RoleFunctionService roleFunctionService;
    @Autowired
    private FunctionService functionService;

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

    //热点功能
    @RequestMapping("hotFunction")
    public String hotFunction(){
        return "system/function/recode";
    }

    //菜单管理
    @RequestMapping("functionManagement")
    public String functionManagement(Model model){
        List<Function> functionList = this.functionService.selectALL();
        model.addAttribute("functionList",functionList);
        System.out.println("functionList:"+functionList);
        return "system/function/function_management";
    }


    //按角色名称查询
    @RequestMapping("functionList")
    public String userList(Model model,String functionName){
        List<Function> functionList = this.functionService.selectByName(functionName);
        model.addAttribute("functionList",functionList);
        System.out.println("functionList:"+functionList);
        return "system/function/function_management";
    }

    //新增菜单
    @RequestMapping("add")
    public String add(Function function){
        Function function1 = this.functionService.selectById1(function.getFunctionId());
        if (function1 == null){
            Function function2 = new Function();
            String functionName = function.getFunctionName();
            function2.setFunctionName(functionName);
            Integer level = function.getLevel();
            function2.setLevel(level);
            Integer parentId = function.getParentId();
            function2.setParentId(parentId);
            String permission = function.getPermission();
            function2.setPermission(permission);
            function2.setStatus("有效");
            Integer child = function.getChild();
            function2.setChild(child);
            String target = function.getTarget();
            function2.setTarget(target);
            this.functionService.insert(function2);
            System.out.println(function2);
            //是一级功能的话默认把新增的功能付给的党支部书记、党支部副书记、党支部纪律检查委员
            if (parentId == null){
                //当前系统中最大的功能ID
                Function function3 = this.functionService.selectMaxId();
                Integer functionId = function3.getFunctionId();
                System.out.println("当前系统中最大的功能ID:"+functionId);
                //党支部书记
                RoleFunction roleFunction = new RoleFunction();
                roleFunction.setRoleId(1);
                roleFunction.setFunctionId(functionId);
                this.roleFunctionService.insert(roleFunction);
                //党支部副书记
                RoleFunction roleFunction1 = new RoleFunction();
                roleFunction1.setRoleId(2);
                roleFunction1.setFunctionId(functionId);
                this.roleFunctionService.insert(roleFunction1);
                //党支部纪律检查委员
                RoleFunction roleFunction2 = new RoleFunction();
                roleFunction2.setRoleId(5);
                roleFunction2.setFunctionId(functionId);
                this.roleFunctionService.insert(roleFunction2);
            }
            return "redirect:/function/functionManagement";
        }else{
            return "system/function/add";
        }
    }

    //修改菜单
    @RequestMapping("edit/{functionId}")
    public String edit(@PathVariable("functionId") Integer functionId, Function function){
        Function function1 = new Function();
        function1.setFunctionId(functionId);
        String functionName = function.getFunctionName();
        function1.setFunctionName(functionName);
        Integer level = function.getLevel();
        function1.setLevel(level);
        Integer parentId = function.getParentId();
        function1.setParentId(parentId);
        String permission = function.getPermission();
        function1.setPermission(permission);
        String status = function.getStatus();
        function1.setStatus(status);
        Integer child = function.getChild();
        function1.setChild(child);
        String target = function.getTarget();
        function1.setTarget(target);
        this.functionService.update(function1);
        System.out.println("---------"+function1);
        return "redirect:/function/functionManagement";
    }

    //删除用户
    @RequestMapping("delete/{functionId}")
    public String delete(@PathVariable("functionId") Integer functionId){
        Function function = this.functionService.selectById(functionId);
        System.out.println("function"+function);
        this.functionService.delete(functionId);
        this.roleFunctionService.deleteByFunction(functionId);
        return "redirect:/function/functionManagement";
    }

}
