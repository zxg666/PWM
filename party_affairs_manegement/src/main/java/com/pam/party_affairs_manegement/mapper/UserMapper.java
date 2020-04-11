package com.pam.party_affairs_manegement.mapper;

import com.pam.party_affairs_manegement.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import sun.awt.SunHints;

import java.security.Key;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
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
    //删除用户
    int delete(Integer userId);
    //用户管理
    List<Map<String, Object>> selectMap();
    //按用户名和角色查找
    List<Map<String,Object>> selectLikeMap(String userName,String organization);
    //按MapID查找
    Map<String, Object> selectMapById(Integer ID);
    //查全部党员
    List<Users> selectByMember();
    //查全部积极分子
    List<Users> selectByActivist();
    //按名字模糊查询党员
    List<Users> selectLikeByMember(String userName);
    //按名字模糊查询积极分子
    List<Users> selectLikeByActivist(String userName);
    //查找流动党员信息
    List<Users> selectByFlow();
    //模糊查询流动党员信息
    List<Users> selectLikeByFlow(String userName);
}
