package com.pam.party_affairs_manegement.service.impl;

import com.pam.party_affairs_manegement.domain.Function;
import com.pam.party_affairs_manegement.domain.Role;
import com.pam.party_affairs_manegement.domain.RoleFunction;
import com.pam.party_affairs_manegement.domain.UserRoleOrganization;
import com.pam.party_affairs_manegement.mapper.RoleFunctionMapper;
import com.pam.party_affairs_manegement.mapper.UserRoleOrganizationMapper;
import com.pam.party_affairs_manegement.service.UserRoleOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleOrganizationServiceImpl implements UserRoleOrganizationService {
    @Autowired
    private UserRoleOrganizationMapper userRoleOrganizationMapper;
    @Autowired
    private RoleFunctionMapper roleFunctionMapper;

    @Override
    public List<UserRoleOrganization> selectByUser(Integer userId) {
        return this.userRoleOrganizationMapper.selectByUser(userId);
    }

    @Override
    public UserRoleOrganization selectByOrganization(String organization) {
        return this.userRoleOrganizationMapper.selectByOrganization(organization);
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
    public int delete(UserRoleOrganization userRole) {
        return this.userRoleOrganizationMapper.delete(userRole);
    }
}
