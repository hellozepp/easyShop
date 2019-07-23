package com.cy.sys.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoodCartVo {

	private int id;
	private Integer goodid;
	private Integer userid;
	private Integer number;
	private String name;
	private Double discount_price;
}
