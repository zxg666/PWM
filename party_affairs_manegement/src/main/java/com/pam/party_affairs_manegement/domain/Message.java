package com.pam.party_affairs_manegement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    //message_id	int
    private Integer messageId;
    //title	varchar
    private String title;
    //content	varchar
    private String content;
    //sender	varchar
    private String sender;
    //remarks	varchar
    private String remarks;
    //send_time	datetime
    private Date sendTime;
    //message_type	varchar
    private String messageType;
    //send_object	int
    private Integer sendObject;
    //task_flag    varchar
    private String taskFlag;
    //status	varchar
    private String status;
    //组装用户
    Users user;
}
