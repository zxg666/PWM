package com.pam.party_affairs_manegement.service;

import com.pam.party_affairs_manegement.domain.RoleFunction;

import java.util.List;

public interface RoleFunctionService {
    //根据角色查找
    List<RoleFunction> selectByRole(Integer role);
    //根据角色查热点功能
    List<RoleFunction> selectByVisit(Integer role);
    //增加记录
    int insert(RoleFunction roleFunction);
    //更新记录
    int update(RoleFunction roleFunction);
    //删除记录
    int delete(RoleFunction roleFunction);
}
