package com.pam.party_affairs_manegement.mapper;

import com.pam.party_affairs_manegement.domain.RoleFunction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleFunctionMapper {
    //根据角色查找
    List<RoleFunction> selectByRole(Integer role);
    //根据角色查热点功能
    List<RoleFunction> selectByVisit(Integer role);
    //增加记录
    int insert(RoleFunction roleFunction);
    //更新记录
    int update(RoleFunction roleFunction);
    //删除记录
    int delete(Integer id);
    //根据角色删除记录
    int deleteByRole(Integer role);
    //根据功能删除记录
    int deleteByFunction(Integer function);
}
