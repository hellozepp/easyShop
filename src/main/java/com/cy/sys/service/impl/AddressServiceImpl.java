package com.cy.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.sys.dao.AddressDao;
import com.cy.sys.entity.Address;
import com.cy.sys.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;

	@Override
	public Address queryAddress(Integer userid) {
		List<Address> addresses = addressDao.queryGoodCart(userid);
		if (addresses == null || addresses.size() == 0) {
			return null;
		}
		return addresses.get(0);
	}
}
