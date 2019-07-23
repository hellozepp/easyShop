package com.cy.sys.controller;

import com.cy.common.vo.JsonResult;
import com.cy.common.vo.PageObject;
import com.cy.common.vo.User;
import com.cy.sys.entity.GoodCart;
import com.cy.common.vo.GoodCartVo;
import com.cy.sys.service.GoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/GoodCart/")
public class GoodCartController {
    @Autowired
    private GoodCartService goodCartService;

    @RequestMapping("findPageObjects")
    public JsonResult findPageObjects(
            Integer userid, Integer pageCurrent) {
        PageObject<GoodCartVo> po = goodCartService.findPageObjects(userid, pageCurrent);
        return new JsonResult(po);
    }

    //查询购物车
    @RequestMapping("queryGoodCart")
    public JsonResult queryGoodCart(Integer userid) {
        return new JsonResult(goodCartService.queryGoodCart(1));
    }

    //插入购物车
    @RequestMapping("insertGoodCart")
    @Transactional
    public JsonResult insertGoodCart(String goodId, String number, HttpServletRequest httpServletRequest) {
        Integer goodIdInt;
        Integer numberInt;
        try {
            goodIdInt = Integer.parseInt(goodId);
            numberInt = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return new JsonResult(e);
        }
        HttpSession session = httpServletRequest.getSession(true);
        User userInfo = (User) session.getAttribute("userInfo");
//        User userInfo = User.builder().id(1).username("123").password("111").nickname("我淘").build();
        if (userInfo == null) {
            return new JsonResult(new Exception("用户未登录!"));
        }
        List<GoodCart> goodCarts = goodCartService.queryGoodCart(userInfo.getId());
        if (goodCarts == null || goodCarts.isEmpty()) {
            return new JsonResult(goodCartService.insertGoodCart(
                    GoodCart.builder().goodid(goodIdInt).userid(userInfo.getId()).number(numberInt).build()
            ));
        }
        for (GoodCart x : goodCarts) {
            if (x != null && x.getGoodid().equals(goodIdInt)) {
                //update
                x.setNumber(x.getNumber() + numberInt);
                return new JsonResult(goodCartService.updateGoodCart(
                        GoodCart.builder().goodid(goodIdInt).userid(userInfo.getId()).number(numberInt).build()
                ));
            }
        }
        //insert it
        return new JsonResult(goodCartService.insertGoodCart(
                GoodCart.builder().goodid(goodIdInt).userid(userInfo.getId()).number(numberInt).build()
        ));
    }

    //删除购物车
    @RequestMapping("doDeleteObjects")
    public JsonResult doDeleteObjects(
            Integer... ids) {
        goodCartService.deleteObjects(ids);
        return new JsonResult("delete ok");
    }

}
