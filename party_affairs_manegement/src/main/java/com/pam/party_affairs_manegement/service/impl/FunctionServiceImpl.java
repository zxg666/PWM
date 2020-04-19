package com.pam.party_affairs_manegement.service.impl;

import com.pam.party_affairs_manegement.domain.Function;
import com.pam.party_affairs_manegement.mapper.FunctionMapper;
import com.pam.party_affairs_manegement.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionMapper functionMapper;

    @Override
    public List<Function> selectALL() {
        return this.functionMapper.selectALL();
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public List<Function> selectByName(String functionName) {
        return this.functionMapper.selectByName(functionName);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public Function selectById(Integer functionId) {
        Function function = this.functionMapper.selectById(functionId);
        List<Function> functionList = this.functionMapper.selectByParent(function.getFunctionId());
        function.setFunctionList(functionList);
        return function;
    }

    @Override
    public Function selectById1(Integer functionId) {
        return this.functionMapper.selectById1(functionId);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public List<Function> selectAllByVisit(Integer parentId) {
        return this.functionMapper.selectAllByVisit(parentId);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public List<Function> selectByLevel() {
        List<Function> functionListAll = this.functionMapper.selectByLevel();
        for (Function function:functionListAll) {
            List<Function> functionList = this.functionMapper.selectByParent(function.getFunctionId());
            function.setFunctionList(functionList);
        }
        return functionListAll;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Integer insert(Function function) {
        return this.functionMapper.insert(function);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Integer update(Function function) {
        return this.functionMapper.update(function);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Integer delete(Integer functionId) {
        return this.functionMapper.delete(functionId);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public List<Function> selectByParent(Integer parentId) {
        return this.functionMapper.selectByParent(parentId);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public Function selectMaxId() {
        return this.functionMapper.selectMaxId();
    }
}
