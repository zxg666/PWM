package com.pam.party_affairs_manegement.service.impl;

import com.pam.party_affairs_manegement.domain.Apply;
import com.pam.party_affairs_manegement.mapper.ApplyMapper;
import com.pam.party_affairs_manegement.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public int insert(Apply apply) {
        return this.applyMapper.insert(apply);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public List<Apply> selectAll() {
        return this.applyMapper.selectAll();
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public List<Apply> selectByNameAndTitle(String eopName, String title) {
        return this.selectByNameAndTitle(eopName,title);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public Apply selectById(Integer eopId) {
        return this.applyMapper.selectById(eopId);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public int update(Apply apply) {
        return this.applyMapper.update(apply);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public int delete(Integer eopId) {
        return this.applyMapper.delete(eopId);
    }
}
