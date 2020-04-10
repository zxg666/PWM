package com.pam.party_affairs_manegement.mapper;

import com.pam.party_affairs_manegement.domain.Organization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrganizationMapper {
    //添加组织
    int insert(Organization organization);
    //按名称和领导查找组织
    Organization selectByName(String organizationName,String organizationLeader);
    //查找所有组织
    List<Organization> selectAll();
    //根据ID查找组织
    Organization selectById(Integer organizationId);
    //修改组织信息
    int update(Organization organization);
    //删除组织
    int delete(Integer organizationId);
}
