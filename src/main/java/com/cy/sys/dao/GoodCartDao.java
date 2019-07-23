package com.cy.sys.dao;

import com.cy.sys.entity.GoodCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodCartDao {
    //插入购物车信息

    @Insert("insert into good_cart(goodid,userid,number) values(#{goodid},#{userid},#{number})")
    public int insertGoodCart(GoodCart goodCart);

    //根据userid查询购物车信息
    @Select("select * from good_cart where userid=#{userid}")
    public List<GoodCart> queryGoodCart(Integer userid);

    //根据userid删除购物车信息

    int deleteObjects(@Param("ids") Integer... ids);

    //查询行数
    @Select("select count(*) from good_cart where userid=#{userid}  for update ")
    int getRowCount(@Param("userid") Integer userid);

    //根据userid查询购物车信息
    @Select("select * from good_cart where userid=#{userid} limit #{startIndex},#{pageSize}")
    List<GoodCart> findPageObjects(
            @Param("userid") Integer userid,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);

    @Update("Update good_cart set  number=number+#{number} where goodid=#{goodid} and userid=#{userid} ")
    int updateGoodCart(GoodCart build);
}
