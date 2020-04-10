package com.pam.party_affairs_manegement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Organization {
    //organization_id	int
    private Integer organizationId;
    //organization_name	varchar
    private String organizationName;
    //organization_leader	varchar
    private String organizationLeader;
    //	organization_info	varchar
    private String organizationInfo;
    //	telephone	varchar
    private String telephone;
    //parent_id	int
    private Integer parentId;
    //entry_time date
    private Date entryTime;
}
