package com.pam.party_affairs_manegement.service.impl;

import com.pam.party_affairs_manegement.domain.*;
import com.pam.party_affairs_manegement.mapper.RoleFunctionMapper;
import com.pam.party_affairs_manegement.mapper.UserRoleOrganizationMapper;
import com.pam.party_affairs_manegement.service.UserRoleOrganizationService;
import com.pam.party_affairs_manegement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleOrganizationServiceImpl implements UserRoleOrganizationService {
    @Autowired
    private UserRoleOrganizationMapper userRoleOrganizationMapper;

    @Override
    public List<UserRoleOrganization> selectByUser(Integer userId) {
        return this.userRoleOrganizationMapper.selectByUser(userId);
    }

    @Override
    public UserRoleOrganization selectByOrganization(Integer userId,String organization) {
        return this.userRoleOrganizationMapper.selectByOrganization(userId,organization);
    }

    @Override
    public UserRoleOrganization selectById(Integer id) {
        return this.userRoleOrganizationMapper.selectById(id);
    }

    @Override
    public List<UserRoleOrganization> selectByRole(Integer roleId) {
        return this.userRoleOrganizationMapper.selectByRole(roleId);
    }

    @Override
    public int insert(UserRoleOrganization userRole) {
        return this.userRoleOrganizationMapper.insert(userRole);
    }

    @Override
    public int update(UserRoleOrganization userRole) {
        return this.userRoleOrganizationMapper.update(userRole);
    }

    @Override
    public int updateByUser(UserRoleOrganization userRoleOrganization, Integer userId) {
        return this.userRoleOrganizationMapper.updateByUser(userRoleOrganization,userId);
    }

    @Override
    public int updateByOrganization(UserRoleOrganization userRoleOrganization, String organization) {
        return this.userRoleOrganizationMapper.updateByOrganization(userRoleOrganization,organization);
    }

    @Override
    public int delete(Integer id) {
        return this.userRoleOrganizationMapper.delete(id);
    }

    @Override
    public int deleteByRole(Integer roleId) {
        return this.userRoleOrganizationMapper.deleteByRole(roleId);
    }

    @Override
    public int deleteByUser(Integer userId) {
        return this.userRoleOrganizationMapper.deleteByUser(userId);
    }
}
