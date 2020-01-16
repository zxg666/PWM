package com.pam.party_affairs_manegement.service.impl;

import com.pam.party_affairs_manegement.domain.Function;
import com.pam.party_affairs_manegement.domain.Role;
import com.pam.party_affairs_manegement.mapper.RoleMapper;
import com.pam.party_affairs_manegement.service.FunctionService;
import com.pam.party_affairs_manegement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private FunctionService functionService;

    @Override
    public int insert(Role user) {
        return this.roleMapper.insert(user);
    }

    @Override
    public List<Role> selectByName(String role) {
        return this.roleMapper.selectByName(role);
    }

    @Override
    public List<Role> selectAll() {
        return this.roleMapper.selectAll();
    }

    @Override
    public Role selectById(Integer roleId) {
        Role role = this.roleMapper.selectById(roleId);
        Function functionList = this.functionService.selectById(role.getRoleId());
        return role;
    }

    @Override
    public int update(Role role) {
        return this.roleMapper.update(role);
    }

    @Override
    public int delete(Role role) {
        return this.roleMapper.delete(role);
    }
}
