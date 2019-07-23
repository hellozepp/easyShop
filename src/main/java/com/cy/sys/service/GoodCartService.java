package com.cy.sys.service;

import com.cy.common.vo.PageObject;
import com.cy.sys.entity.GoodCart;
import com.cy.sys.entity.GoodCartVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodCartService {

    //	根据userid查询购物车
    public List<GoodCart> queryGoodCart(Integer userid);

    //	添加至购物车
    public Integer insertGoodCart(GoodCart goodCart);

    //	根据userid与goodid删除GoodCart
    Integer deleteObjects(@Param("ids") Integer... ids);


    PageObject<GoodCartVo> findPageObjects(
            Integer userid, Integer pageCurrent);

    Integer updateGoodCart(GoodCart build);
}
