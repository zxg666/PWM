package com.pam.party_affairs_manegement.service;

import com.pam.party_affairs_manegement.domain.Function;

import java.util.List;

public interface FunctionService {
    //按ID查找功能
    Function selectById(Integer functionId);

    //按访问量展示功能
    List<Function> selectAllByVisit(Integer parentId);

    //按查级别功能
    List<Function> selectByLevel();

    //增加功能
    int insert(Function function);

    //修改功能
    int update(Function function);

    //删除功能
    int delete(Function function);

    //按父ID查找功能
    List<Function> selectByParent(Integer parentId);
}
