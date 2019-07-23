package com.cy.sys.service;

import org.springframework.stereotype.Service;

import com.cy.sys.entity.Address;

@Service
public interface AddressService {

    //	根据userid查询购物车
    public Address queryAddress(Integer userid);

}
