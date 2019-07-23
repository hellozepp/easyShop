package com.cy.sys.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GoodCart implements Serializable {

    private static final long serialVersionUID = 1016135511376672098L;
    private int id;
    private Integer goodid;
    private Integer userid;
    private Integer number;
}
