package com.pam.party_affairs_manegement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    //user_id	int
    private  Integer userId;
    //user_name	varchar
    private  String userName;
    //password	varchar
    private  String password;
    //sex	varchar
    private String sex;
    //birthday	datetime
    private  String birthday;
    //img	varchar
    private String img;
    //status	tinyint
    private  String status;
    //entry_time	date
    private Date entryTime;
}
