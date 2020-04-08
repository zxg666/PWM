package com.pam.party_affairs_manegement.service;

import com.pam.party_affairs_manegement.domain.Organization;

import java.util.List;

public interface OrganizationService {
    //添加组织
    int insert(Organization organization);
    //按名称查找组织
    Organization selectByName(String organization);
    //查找所有组织
    List<Organization> selectAll();
    //根据ID查找组织
    Organization selectById(Integer organizationId);
    //修改组织信息
    int update(Organization organization);
    //删除组织
    int delete(Organization organization);
}
