package com.cy.sys.dao;

import com.cy.sys.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: zhanglin
 * @Date: 2019/7/21
 * @Time: 5:37 PM
 */
@Mapper
public interface AddressDao {
    @Select("select * from addr where user_id=#{userid}")
    public List<Address> queryGoodCart(Integer userid);

}
