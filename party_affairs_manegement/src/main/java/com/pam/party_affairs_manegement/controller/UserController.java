package com.pam.party_affairs_manegement.controller;

import com.pam.party_affairs_manegement.domain.Users;
import com.pam.party_affairs_manegement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/userManagement")
public class UserController {
    @Autowired
    private UserService userService;

    //用户登录
    @RequestMapping("userLogin")
    @ResponseBody
    public Map<String, Object> userLogin(HttpServletRequest request, Integer userId, String password){
        Map<String, Object> result = new HashMap<String, Object>();
        System.out.println("用户Id:"+userId);
        System.out.println("密码:"+password);
        Users user = userService.selectById(userId);
        System.out.println("根据ID查到的用户"+user);
        if(user != null) {
            if (user.getPassword().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
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
}
