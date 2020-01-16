package com.pam.party_affairs_manegement.service;

import com.pam.party_affairs_manegement.domain.UserRoleOrganization;

import java.util.List;

public interface UserRoleOrganizationService {
    //根据用户查找
    List<UserRoleOrganization> selectByUser(Integer user);
    //根据组织的最高级角色给用户授权功能
    UserRoleOrganization selectByOrganization(String organization);
    //增加记录
    int insert(UserRoleOrganization userRoleOrganization);
    //更新记录
    int update(UserRoleOrganization userRoleOrganization);
    //删除记录
    int delete(UserRoleOrganization userRoleOrganization);
}
