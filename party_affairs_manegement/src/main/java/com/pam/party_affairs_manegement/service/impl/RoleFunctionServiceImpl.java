package com.pam.party_affairs_manegement.service.impl;

import com.pam.party_affairs_manegement.domain.Function;
import com.pam.party_affairs_manegement.domain.RoleFunction;
import com.pam.party_affairs_manegement.mapper.RoleFunctionMapper;
import com.pam.party_affairs_manegement.service.FunctionService;
import com.pam.party_affairs_manegement.service.RoleFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleFunctionServiceImpl implements RoleFunctionService {
    @Autowired
    private RoleFunctionMapper roleFunctionMapper;
    @Autowired
    private FunctionService functionService;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=true)
    public List<RoleFunction> selectByRole(Integer role) {
        List<RoleFunction> roleFunctions = this.roleFunctionMapper.selectByRole(role);
        for (RoleFunction roleFunction:roleFunctions
             ) {
            //组装功能
            Function function = this.functionService.selectById(roleFunction.getFunctionId());
            roleFunction.setFunctions(function);
        }
        return roleFunctions;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<RoleFunction> selectByVisit(Integer role) {
        List<RoleFunction> roleFunctions = this.roleFunctionMapper.selectByVisit(role);
        for (RoleFunction roleFunction:roleFunctions
        ) {
            List<Function> function = this.functionService.selectAllByVisit(roleFunction.getFunctionId());
            roleFunction.setFunctionList(function);
        }
        return roleFunctions;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public int insert(RoleFunction roleFunction) {
        return this.roleFunctionMapper.insert(roleFunction);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public int update(RoleFunction roleFunction) {
        return this.roleFunctionMapper.update(roleFunction);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public int delete(Integer id) {
        return this.roleFunctionMapper.delete(id);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public int deleteByRole(Integer role) {
        return this.roleFunctionMapper.deleteByRole(role);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public int deleteByFunction(Integer function) {
        return this.roleFunctionMapper.deleteByFunction(function);
    }
}
