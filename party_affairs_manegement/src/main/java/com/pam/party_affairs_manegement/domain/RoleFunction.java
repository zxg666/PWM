package com.pam.party_affairs_manegement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleFunction {
    //id	int
    private Integer id;
    //role_id	int
    private Integer roleId;
    //function_id	int
    private Integer functionId;
    //组装功能
    private Function functions;
    //组装热点功能
    private List<Function> functionList;
}
