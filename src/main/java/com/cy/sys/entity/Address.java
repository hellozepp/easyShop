package com.cy.sys.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class Address implements Serializable {

    private static final long serialVersionUID = 101613556376123098L;

    private Integer id;
    private String name;
    private String phone;
    private String address;
    private String type;
    private Date createdTime;
    private Date modifiedTime;
    private Integer user_id;
}
