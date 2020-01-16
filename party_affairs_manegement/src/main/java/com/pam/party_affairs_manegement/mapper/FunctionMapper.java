package com.pam.party_affairs_manegement.mapper;

import com.pam.party_affairs_manegement.domain.Function;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FunctionMapper {
    //按ID查找功能
    Function selectById(Integer functionId);
    //按热度展示15个功能
    List<Function> selectAllByVisit();
    //按查找级别功能
    List<Function> selectByLevel(Integer level);
    //增加功能
    int insert(Function function);
    //修改功能
    int update(Function function);
    //删除功能
    int delete(Function function);
    //按父ID查找功能
    List<Function> selectByParent(Integer parentId);
}
