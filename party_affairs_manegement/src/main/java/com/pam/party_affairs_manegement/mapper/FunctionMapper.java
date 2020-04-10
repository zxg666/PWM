package com.pam.party_affairs_manegement.mapper;

import com.pam.party_affairs_manegement.domain.Function;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FunctionMapper {
    //查全部
    List<Function> selectALL();
    //按ID查找功能
    Function selectById(Integer functionId);
    //唯一单菜单
    Function selectById1(Integer functionId);
    //按热度展示功能
    List<Function> selectAllByVisit(Integer parentId);
    //按查找级别功能
    List<Function> selectByLevel();
    //增加功能
    int insert(Function function);
    //修改功能
    int update(Function function);
    //删除功能
    int delete(Integer functionId);
    //按父ID查找功能
    List<Function> selectByParent(Integer parentId);
}
