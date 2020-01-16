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
public class Role {
    //role_id	int
    private Integer roleId;
    //role	varchar
    private String role;
    //description	varchar
    private String description;
    //status	tinyint
    private boolean status;
    //角色的功能
    private List<Function> functionList;
}
