package com.pam.party_affairs_manegement.mapper;

import com.pam.party_affairs_manegement.domain.UserRoleOrganization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleOrganizationMapper {
    //根据用户查找
    List<UserRoleOrganization> selectByUser(Integer userId);
    //根据组织查权限最大角色
    UserRoleOrganization selectByOrganization(String organization);
    //增加记录
    int insert(UserRoleOrganization userRoleOrganization);
    //更新记录
    int update(UserRoleOrganization userRoleOrganization);
    //删除记录
    int delete(UserRoleOrganization userRoleOrganization);
}
