package com.pam.party_affairs_manegement.service.impl;

import com.pam.party_affairs_manegement.domain.Users;
import com.pam.party_affairs_manegement.mapper.UserMapper;
import com.pam.party_affairs_manegement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public int upImg(Users user) {
        return this.userMapper.upImg(user);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public int delete(Users user) {
        return this.userMapper.delete(user);
    }
}
