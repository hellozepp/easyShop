package com.cy.sys.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zhanglin
 * @Date: 2019/7/20
 * @Time: 10:56 PM
 */
@Data
@Builder
public class User  implements Serializable {
        private static final long serialVersionUID = 1016131231213572098L;
    public Integer id;
    public String nickname;
    public String password;
    public String email;
    public String tel;
    public String picture;
    public String username;
    public String idcard;
    public String point;

}
