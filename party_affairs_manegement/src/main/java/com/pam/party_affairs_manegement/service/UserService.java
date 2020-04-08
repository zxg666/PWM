package com.pam.party_affairs_manegement.service;


import com.pam.party_affairs_manegement.domain.Users;

import java.util.List;
import java.util.Map;

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
    int upImg(Integer userId);
    //根据ID删除用户
    int delete(Integer userId);
    //用户管理
    List<Map<String,Object>> selectMap();
    //按用户名和角色查找
    List<Map<String,Object>> selectLikeMap(String userName,String organization);
    //按MapID查找
    Map<String, Object> selectMapById(Integer ID);
}
