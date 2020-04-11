package com.pam.party_affairs_manegement.service;

import com.pam.party_affairs_manegement.domain.Apply;

import java.util.List;

public interface ApplyService {
    //添加申请人员
    int insert(Apply apply);
    //查找所有申请人员
    List<Apply> selectAll();
    //按名字或者标题查找申请人员
    List<Apply> selectByNameAndTitle(String eopName,String title);
    //根据ID查找申请人员
    Apply selectById(Integer eopId);
    //修改申请人员信息
    int update(Apply apply);
    //删除申请人员
    int delete(Integer eopId);
}
