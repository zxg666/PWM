package com.pam.party_affairs_manegement.service.impl;

import com.pam.party_affairs_manegement.domain.Function;
import com.pam.party_affairs_manegement.domain.RoleFunction;
import com.pam.party_affairs_manegement.mapper.RoleFunctionMapper;
import com.pam.party_affairs_manegement.service.FunctionService;
import com.pam.party_affairs_manegement.service.RoleFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleFunctionServiceImpl implements RoleFunctionService {
    @Autowired
    private RoleFunctionMapper roleFunctionMapper;
    @Autowired
    private FunctionService functionService;

    @Override
    public List<RoleFunction> selectByRole(Integer role) {
        List<RoleFunction> roleFunctions = this.roleFunctionMapper.selectByRole(role);
        for (RoleFunction roleFunction:roleFunctions
             ) {
            Function function = this.functionService.selectById(roleFunction.getFunctionId());
            roleFunction.setFunctions(function);
        }
        return roleFunctions;
    }

    @Override
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
    public int insert(RoleFunction roleFunction) {
        return this.roleFunctionMapper.insert(roleFunction);
    }

    @Override
    public int update(RoleFunction roleFunction) {
        return this.roleFunctionMapper.update(roleFunction);
    }

    @Override
    public int delete(RoleFunction roleFunction) {
        return this.roleFunctionMapper.delete(roleFunction);
    }
}
