package com.cy.sys.controller;

import com.cy.common.vo.JsonResult;
import com.cy.sys.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Address/")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("queryAddress")
    public JsonResult queryGoodCart(Integer userid) {
        return new JsonResult(addressService.queryAddress(1));
    }

}
