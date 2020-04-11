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
    //member_flag	varchar
    private String memberFlag;
    //activist_flag	varchar
    private String activistFlag;
    //status	tinyint
    private  String status;
    //entry_time	date
    private Date entryTime;
    //national	varchar
    private String national;
    //native_place	varchar
    private String nativePlace;
    //party_date	varchar
    private String partyDate;
    //party_introducer	varchar
    private String partyIntroducer;
    //telephone	varchar
    private String telephone;
    //education	varchar
    private String education;
    //flow_flag	varchar
    private String flowFlag;
}
