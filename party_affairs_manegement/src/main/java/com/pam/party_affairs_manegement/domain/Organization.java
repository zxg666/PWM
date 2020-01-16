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
public class Organization {
    //organization_id	int
    private Integer organizationId;
    //organization_name	varchar
    private String organizationName;
    //parent_id	int
    private Integer parentId;
    //entry_time date
    private Date entryTime;
}
