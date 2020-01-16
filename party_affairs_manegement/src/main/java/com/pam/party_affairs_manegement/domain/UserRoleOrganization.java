package com.pam.party_affairs_manegement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRoleOrganization {
    //id	int
    private Integer id;
    //user_id	int
    private Integer userId;
    //role_id	int
    private Integer roleId;
    //organization	varchar
    private String organization;
    //entry_time	date
    private Date entryTime;
}
