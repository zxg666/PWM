package com.pam.party_affairs_manegement.service;


import com.pam.party_affairs_manegement.domain.Users;

import java.util.List;

public interface UserService {
    //添加用户
    int insert(Users user);
    //按姓名查找用户
    List<Users> selectByName(String userName);
    //查找所有用户
    List<Users>  selectAll();
    //根据ID查找用户
    Users selectById(Integer userId);
    //修改用户信息
    int update(Users user);
    //用户图片上传
    int upImg(Users user);
    //根据ID删除用户
    int delete(Users user);
}
