package com.pam.party_affairs_manegement.service.impl;

import com.pam.party_affairs_manegement.domain.Organization;
import com.pam.party_affairs_manegement.mapper.OrganizationMapper;
import com.pam.party_affairs_manegement.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public int insert(Organization organization) {
        return this.organizationMapper.insert(organization);
    }

    @Override
    public Organization selectByName(String organizationName,String organizationLeader) {
        return this.organizationMapper.selectByName(organizationName,organizationLeader);
    }

    @Override
    public List<Organization> selectAll() {
        return this.organizationMapper.selectAll();
    }

    @Override
    public Organization selectById(Integer organizationId) {
        return this.organizationMapper.selectById(organizationId);
    }

    @Override
    public int update(Organization organization) {
        return this.organizationMapper.update(organization);
    }

    @Override
    public int delete(Integer organizationId) {
        return this.organizationMapper.delete(organizationId);
    }
}
