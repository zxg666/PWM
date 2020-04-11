package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.Organization;
import com.pam.party_affairs_manegement.domain.Role;
import com.pam.party_affairs_manegement.domain.UserRoleOrganization;
import com.pam.party_affairs_manegement.domain.Users;
import com.pam.party_affairs_manegement.service.OrganizationService;
import com.pam.party_affairs_manegement.service.RoleService;
import com.pam.party_affairs_manegement.service.UserRoleOrganizationService;
import com.pam.party_affairs_manegement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private UserRoleOrganizationService userRoleOrganizationService;
    @Autowired
    private RoleService roleService;

    //用户登录
    @RequestMapping("userLogin")
    @ResponseBody
    public Map<String, Object> userLogin(HttpServletRequest request, Integer userId, String password,String organization){
        Map<String, Object> result = new HashMap<String, Object>();
        System.out.println("用户Id:"+userId);
        System.out.println("密码:"+password);
        System.out.println("组织:"+organization);
        Users user = this.userService.selectById(userId);
        System.out.println("根据ID查到的用户"+user);
        if(user != null) {
            if (user.getPassword().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("organization", organization);
                result.put("suc",true);
            }else {
                System.out.printf("密码错误！\n");
                result.put("fail",true);
            }
        }else {
            System.out.printf("用户不存在！\n");
            result.put("nobody",true);
        }
        return result;
    }

    //用户管理
    @RequestMapping("userManagement")
    public String userManagement(Model model){
        List<Map<String, Object>> userList = this.userService.selectMap();
        model.addAttribute("userList",userList);
        System.out.println("userList1:"+userList);
        List<Organization> organizationList = this.organizationService.selectAll();
        model.addAttribute("organizationList",organizationList);
        System.out.println("organizationList"+organizationList);
        return "system/user/user_management";
    }

    //按用户名和角色查询用户
    @RequestMapping("userList")
    public String userList(Model model,String userName,String organization){
        List<Map<String,Object>> userList = this.userService.selectLikeMap(userName,organization);
        model.addAttribute("userList",userList);
        System.out.println("users:"+userList);
        List<Organization> organizationList = this.organizationService.selectAll();
        model.addAttribute("organizationList",organizationList);
        return "system/user/user_management";
    }

    //新增用户
    @RequestMapping("add")
    public String add(Users user,String organization,String role){
        Users user1 = this.userService.selectById(user.getUserId());
        if (user1 == null){
            Users user2 = new Users();
            Integer userId = user.getUserId();
            user2.setUserId(userId);
            String userName = user.getUserName();
            user2.setUserName(userName);
            String password = user.getPassword();
            user2.setPassword(password);
            String sex = user.getSex();
            user2.setSex(sex);
            String birthday = user.getBirthday();
            user2.setBirthday(birthday);
            user2.setImg("/upimgs/user/0.png");
            String status = user.getStatus();
            user2.setStatus(status);
            String national = user.getNational();
            user2.setNational(national);
            String nativePlace = user.getNativePlace();
            user2.setNativePlace(nativePlace);
            String telephone = user.getTelephone();
            user2.setTelephone(telephone);
            String education = user.getEducation();
            user2.setEducation(education);
            user2.setEntryTime(new Date());
            //插入关联表相关数据
            UserRoleOrganization userRoleOrganization1 = new UserRoleOrganization();
            Role role1 = this.roleService.selectByName(role);
            Integer roleId = role1.getRoleId();
            userRoleOrganization1.setUserId(userId);
            System.out.println("---------"+userId);
            userRoleOrganization1.setRoleId(roleId);
            System.out.println("---------"+roleId);
            userRoleOrganization1.setOrganization(organization);
            userRoleOrganization1.setEntryTime(new Date());
            //默认变化日期
            String partyDate = "0000-00-00";
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("默认变化日期"+partyDate);
            //改变后的日期
            String partyDate1 = (new SimpleDateFormat("YYYY-MM-DD")).format(new Date());
            System.out.println("改变后的日期"+partyDate1);
            //判断是不是党员、积极分子、流动党员
            if (roleId==6){
                user2.setMemberFlag("是");
                user2.setPartyDate(partyDate1);
                System.out.println("党员！");
            } else if (roleId==13){
                user2.setActivistFlag("是");
                user2.setPartyDate(partyDate1);
                System.out.println("积极分子！");
            }else{
                user2.setMemberFlag("否");
                user2.setActivistFlag("否");
                user2.setPartyDate(partyDate);
                System.out.println("变化日期："+new Date("0000-00-00"));
            }
            user2.setFlowFlag("否");
            user2.setPartyIntroducer("无");
            this.userService.insert(user2);
            System.out.println(user);
            System.out.println("---------"+userRoleOrganization1);
            this.userRoleOrganizationService.insert(userRoleOrganization1);
            return "redirect:/user/userManagement";
        }else{
            return "system/user/user_add";
        }
    }

    //修改用户
    @RequestMapping("edit/{ID}")
    public String edit(@PathVariable("ID") Integer ID,Users user,String organization,String role){
        UserRoleOrganization userRoleOrganization1 = new UserRoleOrganization();
        userRoleOrganization1.setId(ID);
        Integer userId = user.getUserId();
        userRoleOrganization1.setUserId(userId);
        Role role1 = this.roleService.selectByName(role);
        Integer roleId = role1.getRoleId();
        userRoleOrganization1.setRoleId(roleId);
        System.out.println("---------"+roleId);
        userRoleOrganization1.setOrganization(organization);
        System.out.println("---------"+organization);
        this.userRoleOrganizationService.update(userRoleOrganization1);
        System.out.println("---------"+userRoleOrganization1);
        Users user1 = new Users();
        user1.setUserId(userId);
        String userName = user.getUserName();
        user1.setUserName(userName);
        String password = user.getPassword();
        user1.setPassword(password);
        String sex = user.getSex();
        user1.setSex(sex);
        String birthday = user.getBirthday();
        user1.setBirthday(birthday);
        user1.setImg("/upimgs/user/0.png");
        //默认变化日期
        String partyDate = "0000-00-00";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("默认变化日期"+partyDate);
        //改变后的日期
        String partyDate1 = (new SimpleDateFormat("YYYY-MM-DD")).format(new Date());
        System.out.println("改变后的日期"+partyDate1);
        //判断是不是党员、积极分子、流动党员
        if (roleId==6){
            user1.setMemberFlag("是");
            user1.setPartyDate(partyDate1);
        } else if (roleId==13){
            user1.setActivistFlag("是");
            user1.setPartyDate(partyDate1);
        }else{
            user1.setMemberFlag("否");
            user1.setActivistFlag("否");
            user1.setPartyDate(partyDate);
        }

        if (userRoleOrganization1.getOrganization().equals(organization)){
            user1.setFlowFlag("是");
            user1.setPartyDate(partyDate1);
        }
        user1.setFlowFlag("否");
        user1.setPartyIntroducer("无");
        String status = user.getStatus();
        user1.setStatus(status);
        String national = user.getNational();
        user1.setNational(national);
        String nativePlace = user.getNativePlace();
        user1.setNativePlace(nativePlace);
        String telephone = user.getTelephone();
        user1.setTelephone(telephone);
        String education = user.getEducation();
        user1.setEducation(education);
        this.userService.update(user1);
        System.out.println("---------"+user1);
        return "redirect:/user/userManagement";
    }

    //删除用户
    @RequestMapping("delete/{ID}")
    public String delete(@PathVariable("ID") Integer ID){
        UserRoleOrganization userRoleOrganization = this.userRoleOrganizationService.selectById(ID);
        System.out.println("userRoleOrganization"+userRoleOrganization);
        this.userService.delete(userRoleOrganization.getUserId());
        this.userRoleOrganizationService.delete(ID);
        return "redirect:/user/userManagement";
    }

    //批量删除用户
    @RequestMapping("delete")
    public String delete(){

        return "redirect:/user/userManagement";
    }
}
