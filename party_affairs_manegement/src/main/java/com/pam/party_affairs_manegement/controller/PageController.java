package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.*;
import com.pam.party_affairs_manegement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleFunctionService roleFunctionService;
    @Autowired
    private UserRoleOrganizationService userRoleOrganizationService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private FunctionService functionService;
    @Autowired
    private ApplyService applyService;

     //跳转到首页
    @RequestMapping("index")
    public String index(Model model, @RequestParam("userId") Integer userId,
                        @RequestParam("organization") String organization){
        //展示用户信息
        Users user = this.userService.selectById(userId);
        model.addAttribute("user",user);
        System.out.println("user:"+user);
        //按权限查出功能菜单
        UserRoleOrganization userRoleOrganization = this.userRoleOrganizationService.selectByOrganization(userId,organization);
        List<RoleFunction> roleFunction = this.roleFunctionService.selectByRole(userRoleOrganization.getRoleId());
        System.out.println("roleFunction:"+roleFunction);
        model.addAttribute("roleFunction",roleFunction);
        return "index";
    }
    //跳转到主页面
    @RequestMapping("main")
    public String main(){
        return "main";
    }
    //跳转到登录页
    @RequestMapping("login")
    public  String login(Model model){
        List<Organization> organizationList = this.organizationService.selectAll();
        model.addAttribute("organizationList",organizationList);
        return "system/user/login";
    }
    //跳转到表单页
    @RequestMapping("form")
    public String form(){
        return "form";
    }
    //跳转到表格页
    @RequestMapping("table")
    public String table(){
        return "table";
    }
    //跳转到首页
    @RequestMapping("home")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        Integer userId = user.getUserId();
        String organization = (String) session.getAttribute("organization");
        //按热度展示12个功能
        UserRoleOrganization userRoleOrganization = this.userRoleOrganizationService.selectByOrganization(userId,organization);
        List<RoleFunction> hotFunction = this.roleFunctionService.selectByVisit(userRoleOrganization.getRoleId());
        System.out.println("hotFunction:"+hotFunction);
        model.addAttribute("hotFunction",hotFunction);
        return "home";
    }
    //跳转到工作页
    @RequestMapping("work")
    public String work(){
        return "service/work";
    }

    //跳转到用户新增页
    @RequestMapping("user_add")
     public String user_add(Model model){
        //组织
        List<Organization> organizationList = this.organizationService.selectAll();
        model.addAttribute("organizationList",organizationList);
        //角色
        List<Role> roleList = this.roleService.selectAll();
        model.addAttribute("roleList",roleList);
        return "system/user/user_add";
    }

    //跳转到用户编辑页
    @RequestMapping("userEdit/{ID}")
    public String userEdit(@PathVariable("ID") Integer ID,Model model){
        Map<String,Object> userRoleOrganization = this.userService.selectMapById(ID);
        model.addAttribute("userRoleOrganization",userRoleOrganization);
        System.out.println("userRoleOrganization:"+userRoleOrganization);
        model.addAttribute("ID",ID);
        System.out.println("ID:"+ID);
        //组织
        List<Organization> organizationList = this.organizationService.selectAll();
        model.addAttribute("organizationList",organizationList);
        //角色
        List<Role> roleList = this.roleService.selectAll();
        model.addAttribute("roleList",roleList);
        return "system/user/user_edit";
    }

    //跳转到角色编辑页
    @RequestMapping("roleEdit/{roleId}")
    public String roleEdit(@PathVariable("roleId") Integer roleId,Model model){
        Role roleRecord = this.roleService.selectById(roleId);
        model.addAttribute("roleRecord",roleRecord);
        System.out.println("roleRecord:"+roleRecord);
        model.addAttribute("roleId",roleId);
        System.out.println("roleId:"+roleId);
        return "system/role/role_edit";
    }

    //跳转到菜单新增页
    @RequestMapping("function_add")
    public String function_add(){
        return "system/function/function_add";
    }

    //跳转到菜单编辑页
    @RequestMapping("functionEdit/{functionId}")
    public String functionEdit(@PathVariable("functionId") Integer functionId,Model model){
       Function function = this.functionService.selectById1(functionId);
        model.addAttribute("function",function);
        System.out.println("function:"+function);
        model.addAttribute("functionId",functionId);
        System.out.println("functionId:"+functionId);
        return "system/function/function_edit";
    }

    //跳转到党组织新增页
    @RequestMapping("organization_add")
    public String organization_add(){
        return "basic/organization/organization_add";
    }

    //跳转到党组织编辑页
    @RequestMapping("organizationEdit/{organizationId}")
    public String organizationEdit(@PathVariable("organizationId") Integer organizationId,Model model){
        Organization organization = this.organizationService.selectById(organizationId);
        model.addAttribute("organization",organization);
        System.out.println("organization:"+organization);
        return "basic/organization/organization_edit";
    }

    //跳转到入党申请审批页
    @RequestMapping("applyEdit/{eopId}")
    public String applyEdit(@PathVariable("eopId") Integer eopId,Model model){
        Apply apply = this.applyService.selectById(eopId);
        model.addAttribute("apply",apply);
        System.out.println("apply:"+apply);
        List<Users> usersList = this.userService.selectAll();
        System.out.println("usersList"+usersList);
        model.addAttribute("usersList",usersList);
        return "service/member/apply_edit";
    }

    //跳转到成功页面
    @RequestMapping("success")
    public String success(){
        return "system/result/success";
    }

    //跳转到失败页面
    @RequestMapping("fail")
    public String fail(){
        return "system/result/fail";
    }
}
