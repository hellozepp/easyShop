package com.cy.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Good implements Serializable{
	
	private static final long serialVersionUID = -8855288901795804127L;
	private Integer id;
	private String name;
	private Double price;
	private String info;
	private String image;
	private Double discount_price;
	private Byte discount;
	private Integer stock;
	private Integer sales;
	private Float score;
	private Integer goodtype_id;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	
}
