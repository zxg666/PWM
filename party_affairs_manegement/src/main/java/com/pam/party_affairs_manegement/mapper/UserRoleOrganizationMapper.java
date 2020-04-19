package com.pam.party_affairs_manegement.mapper;

import com.pam.party_affairs_manegement.domain.UserRoleOrganization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleOrganizationMapper {
    //根据用户查找
    List<UserRoleOrganization> selectByUser(Integer userId);
    //根据用户组织查权限最大角色
    UserRoleOrganization selectByOrganization(Integer userId,String organization);
    //根据ID查找
    UserRoleOrganization selectById(Integer id);
    //根据角色查找用户
    List<UserRoleOrganization> selectByRole(Integer roleId);
    //增加记录
    int insert(UserRoleOrganization userRoleOrganization);
    //更新记录
    int update(UserRoleOrganization userRoleOrganization);
    //根据用户更新记录
    int updateByUser(UserRoleOrganization userRoleOrganization,Integer userId);
    //根据组织更新记录
    int updateByOrganization(UserRoleOrganization userRoleOrganization,String organization);
    //删除记录
    int delete(Integer id);
    //根据角色删除
    int deleteByRole(Integer roleId);
    //根据用户删除
    int deleteByUser(Integer userId);
}
