package com.pam.party_affairs_manegement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
}
