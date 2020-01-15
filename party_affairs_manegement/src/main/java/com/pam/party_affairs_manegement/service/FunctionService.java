package com.pam.party_affairs_manegement.service;

import com.pam.party_affairs_manegement.domain.Function;

import java.util.List;

public interface FunctionService {
    //按ID查找功能
    Function selectById(Integer functionId);

    //按访问量展示功能
    List<Function> selectAllByVisit();

    //按查级别功能
    List<Function> selectByLevel(Integer level);

    //增加功能
    Function insert(Integer functionId);

    //修改功能
    Function update(Integer functionId);

    //删除功能
    Function delete(Integer functionId);

    //按父ID查找功能
    List<Function> selectByParent(Integer parentId);
}
