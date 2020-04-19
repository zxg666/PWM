package com.pam.party_affairs_manegement.service;

import com.pam.party_affairs_manegement.domain.Function;

import java.util.List;

public interface FunctionService {
    //查全部
    List<Function> selectALL();

    //按角色名字查询
    List<Function> selectByName(String functionName);

    //按ID查找功能
    Function selectById(Integer functionId);

    //唯一单菜单
    Function selectById1(Integer functionId);

    //按访问量展示功能
    List<Function> selectAllByVisit(Integer parentId);

    //查一级功能
    List<Function> selectByLevel();

    //增加功能
    Integer insert(Function function);

    //修改功能
    Integer update(Function function);

    //删除功能
    Integer delete(Integer functionId);

    //按父ID查找功能
    List<Function> selectByParent(Integer parentId);

    //查找的最大的功能ID，用于新增功能时给角色赋权
    Function selectMaxId();
}
