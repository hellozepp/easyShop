package com.cy.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.common.vo.JsonResult;
import com.cy.sys.entity.User;

@RestController
@RequestMapping("/UserInfo/")
public class UserInfoController {

    @RequestMapping("{queryUserInfo}")
    //可以设置一个token获取当前用户信息
    public JsonResult queryUserInfo(HttpServletRequest httpServletRequest) {
//     HttpSession session = httpServletRequest.getSession(true);
//      User userInfo = (User) session.getAttribute("userInfo");
      User userInfo = User.builder().id(1).username("123").password("").nickname("我淘").build();
        if (userInfo == null) {
            return new JsonResult(new Exception("用户未登录!"));
        }
        userInfo.setPassword("");
        return new JsonResult(userInfo);
    }
}
