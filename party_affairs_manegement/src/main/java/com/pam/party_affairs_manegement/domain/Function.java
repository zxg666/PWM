package com.pam.party_affairs_manegement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Function {
    // function_id	int
    private Integer functionId;
    // function_name	varchar
    private String functionName;
    // function_name	varchar
    private Integer level;
    // parent_id	int
    private Integer parentId;
    // permission	varchar
    private String permission;
    // status	tinyint
    private boolean status;
    //visit	    int
    private Integer visit;
    //child	    int
    private Integer child;
    //target	varchar
    private String target;
    //子功能集
    private List<Function> functionList;
}
