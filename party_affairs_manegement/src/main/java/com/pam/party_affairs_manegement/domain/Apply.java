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
public class Apply {
    //eop_id	int
    private Integer eopId;
    //eop_name	varchar
    private String eopName;
    //sex	varchar
    private String sex;
    //national	varchar
    private String national;
    //native_place  varchar
    private String nativePlace;
    //birthday	varchar
    private String birthday;
    //post	varchar
    private String post;
    //education	varchar
    private String education;
    //title	varchar
    private String title;
    //content	varchar
    private String content;
    //application_date	date
    private Date applicationDate;
    //opinion	varchar
    private String opinion;
    //telephone	varchar
    private String telephone;
}
