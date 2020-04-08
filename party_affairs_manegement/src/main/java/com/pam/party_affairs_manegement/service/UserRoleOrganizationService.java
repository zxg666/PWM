package com.pam.party_affairs_manegement.service;

import com.pam.party_affairs_manegement.domain.UserRoleOrganization;

import java.util.List;

public interface UserRoleOrganizationService {
    //根据用户查找
    List<UserRoleOrganization> selectByUser(Integer user);
    //根据用户组织查权限最大角色
    UserRoleOrganization selectByOrganization(Integer userId,String organization);
    //根据ID查找
    UserRoleOrganization selectById(Integer id);
    //增加记录
    int insert(UserRoleOrganization userRoleOrganization);
    //更新记录
    int update(UserRoleOrganization userRoleOrganization);
    //删除记录
    int delete(Integer id);
}
