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
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public Function selectById(Integer functionId) {
        Function function = this.functionMapper.selectById(functionId);
        List<Function> functionList = this.functionMapper.selectByParent(function.getFunctionId());
        function.setFunctionList(functionList);
        return function;
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
            if (function.getParentId() == null) {
                List<Function> functionList = this.functionMapper.selectByParent(function.getFunctionId());
                function.setFunctionList(functionList);
            }
        }
        return functionListAll;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public int insert(Function function) {
        return this.functionMapper.insert(function);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public int update(Function function) {
        return this.functionMapper.update(function);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public int delete(Function function) {
        return this.functionMapper.delete(function);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public List<Function> selectByParent(Integer parentId) {
        return this.functionMapper.selectByParent(parentId);
    }
}
