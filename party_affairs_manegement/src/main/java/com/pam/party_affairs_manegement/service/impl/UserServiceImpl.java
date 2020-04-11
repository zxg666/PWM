package com.pam.party_affairs_manegement.service.impl;

import com.pam.party_affairs_manegement.domain.Users;
import com.pam.party_affairs_manegement.mapper.UserMapper;
import com.pam.party_affairs_manegement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public int insert(Users user) {
        return this.userMapper.insert(user);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<Users> selectByName(String userName) {
        return this.userMapper.selectByName(userName);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<Users> selectAll() {
        return this.userMapper.selectAll();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public Users selectById(Integer userId) {
        return this.userMapper.selectById(userId);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public int update(Users user) {
        return this.userMapper.update(user);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public int upImg(Integer userId) {
        return this.userMapper.upImg(userId);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public int delete(Integer userId) {
        return this.userMapper.delete(userId);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<Map<String, Object>> selectLikeMap(String userName, String organization) {
        return this.userMapper.selectLikeMap(userName,organization);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public Map<String, Object> selectMapById(Integer ID) {
        return this.userMapper.selectMapById(ID);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<Users> selectByMember() {
        return this.userMapper.selectByMember();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<Users> selectByActivist() {
        return this.userMapper.selectByActivist();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<Users> selectLikeByMember(String userName) {
        return this.userMapper.selectLikeByMember(userName);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<Users> selectLikeByActivist(String userName) {
        return this.userMapper.selectLikeByActivist(userName);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<Users> selectByFlow() {
        return this.userMapper.selectByFlow();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<Users> selectLikeByFlow(String userName) {
        return this.userMapper.selectLikeByFlow(userName);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<Map<String, Object>> selectMap() {
        return this.userMapper.selectMap();
    }
}
