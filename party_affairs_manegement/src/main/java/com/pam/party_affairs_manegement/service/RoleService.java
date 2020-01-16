package com.pam.party_affairs_manegement.service;

import com.pam.party_affairs_manegement.domain.Role;

import java.util.List;

public interface RoleService {
    //添加角色
    int insert(Role user);
    //按名称查找角色
    List<Role> selectByName(String role);
    //查找所有角色
    List<Role> selectAll();
    //根据ID查找角色以及其功能
    Role selectById(Integer roleId);
    //修改角色信息
    int update(Role role);
    //删除角色
    int delete(Role role);
}
