package com.pam.party_affairs_manegement;

import com.pam.party_affairs_manegement.domain.*;
import com.pam.party_affairs_manegement.mapper.FunctionMapper;
import com.pam.party_affairs_manegement.mapper.RoleFunctionMapper;
import com.pam.party_affairs_manegement.mapper.RoleMapper;
import com.pam.party_affairs_manegement.mapper.UserRoleOrganizationMapper;
import com.pam.party_affairs_manegement.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyAffairsManegementApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserService userService;

    @Test
    public void selectAll(){
        List<Users> usersList = userService.selectAll();
        for (Users user : usersList) {
            System.out.println(user);
        }
    }
    @Test
    public void selectMap(){
        List<Map<String,Object>> usersList = this.userService.selectMap();
        System.out.println(usersList);
    }
    @Test
    public  void insertUser(){
        Users user = new Users();
        user.setUserId(1139399);
        user.setUserName("zxg");
        user.setPassword("ddf");
        user.setEntryTime(new Date());
        this.userService.insert(user);
    }
    @Test
    public void selectById(){
        Users user = userService.selectById(1139301);
        System.out.println(user);
    }

    @Autowired
    private FunctionMapper functionMapper;
    @Autowired
    private FunctionService functionService;

    @Test
    public void selectFunctionById(){
        Function function = this.functionService.selectById(2);
        System.out.println(function);
    }

    @Test
    public void selectFunctionByVisit(){
        List<Function> function = this.functionService.selectAllByVisit(1);
        System.out.println(function);
    }

    @Test
    public void selectByLevel(){
        List<Function> functionList = this.functionMapper.selectByLevel();
        for (Function functions:functionList
        ) {
            System.out.println(functions);
        }
    }

    @Test
    public void selectFunctionByParent(){
        List<Function> functionLists = this.functionService.selectByParent(1);
        for (Function function:functionLists) {
            System.out.println(function);
        }
    }


    @Autowired
    private UserRoleOrganizationService userRoleOrganizationService;

    @Test
    public void selectByUser(){
        List<UserRoleOrganization> userRoleList = this.userRoleOrganizationService.selectByUser(1139301);
        for (UserRoleOrganization userRole:userRoleList){
            System.out.println(userRole);
        }
    }

    @Test
    public void selectByOrganizations(){
        List<UserRoleOrganization> userRoleList = this.userRoleOrganizationService.selectByUser(1139301);
        for (UserRoleOrganization userRole:userRoleList){
            System.out.println(userRole);
        }
    }

    @Test
    public void insertByUser(){
        UserRoleOrganization userRole = new UserRoleOrganization();
        userRole.setRoleId(7);
        userRole.setUserId(5);
        userRole.setOrganization("昆明学院党总支");
        userRole.setEntryTime(new Date());
        this.userRoleOrganizationService.insert(userRole);
    }

    @Test
    public void updateByUser(){
        UserRoleOrganization userRole = new UserRoleOrganization();
        userRole.setId(10);
        userRole.setRoleId(9);
        userRole.setUserId(1139302);
        userRole.setOrganization("昆明学院党总支");
        userRole.setEntryTime(new Date());
        this.userRoleOrganizationService.update(userRole);
    }

    @Test
    public void deleteByUser(){
        this.userRoleOrganizationService.delete(1139307);
    }

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleService roleService;
    @Test
    public void insertRole(){
        Role role = new Role();
        role.setRole("测试");
        role.setDescription("dfd");
        this.roleMapper.insert(role);
    }

    @Test
    public void updateRole(){
        Role role = new Role();
        role.setRoleId(8);
        role.setRole("测试");
        role.setDescription("sss");
        this.roleMapper.update(role);
    }

    @Test
    public void deleteRole(){
        Role role = new Role();
        role.setRoleId(8);
        this.roleMapper.delete(1);
    }

    @Autowired
    private UserRoleOrganizationMapper userRoleOrganizationMapper;
    @Test
    public void selectByOrganization(){
        System.out.println(this.userRoleOrganizationMapper.selectByOrganization(1139301,"信息工程学院"));
    }

    @Autowired
    private RoleFunctionMapper roleFunctionMapper;
    @Autowired
    private RoleFunctionService roleFunctionService;
    @Test
    public void selectByRole(){
        List<RoleFunction> roleFunctions = this.roleFunctionService.selectByRole(1);
        for (RoleFunction roleFunction:roleFunctions
             ) {
            System.out.println(roleFunction);
        }
    }

    @Test
    public void selectAllByVisit(){
        List<RoleFunction> roleFunctions = this.roleFunctionService.selectByVisit(1);
        for (RoleFunction roleFunction:roleFunctions
        ) {
            System.out.println(roleFunction);
        }
    }

    @Test
    public void selectByRoleService(){
        List<RoleFunction> roleFunctions = this.roleFunctionService.selectByRole(1);
        for (RoleFunction roleFunction:roleFunctions
        ) {
            System.out.println(roleFunction);
        }
    }

    @Test
    public void insertRoleFunction(){
        RoleFunction roleFunction = new RoleFunction();
        roleFunction.setRoleId(2);
        roleFunction.setFunctionId(1);
        this.roleFunctionMapper.insert(roleFunction);
    }

    @Test
    public void selectFunctionByRole(){
        List<RoleFunction> roleFunctionList = this.roleFunctionService.selectByRole(1);
        for (RoleFunction roleFunction:roleFunctionList
             ) {
            System.out.println(roleFunction);
        }
    }

    @Test
    public void selectByVisit(){
        List<RoleFunction> roleFunctionList = this.roleFunctionService.selectByVisit(1);
        for (RoleFunction roleFunction:roleFunctionList
        ) {
            System.out.println(roleFunction);
        }
    }

    @Autowired
    private OrganizationService organizationService;
    @Test
    public void findAll(){
        List<Organization> organizations = this.organizationService.selectAll();
        for (Organization organization:organizations
             ) {
            System.out.println(organization);
        }
    }

}
