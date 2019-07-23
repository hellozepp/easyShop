package com.cy.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.vo.PageObject;
import com.cy.sys.dao.GoodCartDao;
import com.cy.sys.dao.SysGoodDao;
import com.cy.sys.entity.Good;
import com.cy.sys.entity.GoodCart;
import com.cy.sys.entity.GoodCartVo;
import com.cy.sys.service.GoodCartService;

@Service
public class GoodCartServiceIml implements GoodCartService {
	@Autowired
	private GoodCartDao goodCartDao;
	@Autowired
	private SysGoodDao goodDao;
	
	// 根据userid查询购物车
	@Override
	public List<GoodCart> queryGoodCart(Integer userid) {
		if (userid == 0 || userid < 1) {
			throw new IllegalArgumentException("id值无效");
		}
		List<GoodCart> goodCartList = goodCartDao.queryGoodCart(userid);
		return goodCartList;
	}

	// 根据userid与goodid删除GoodC
	@Override
	public Integer deleteObjects(Integer... ids) {
		// 1.参数校验
		if (ids == null || ids.length == 0) {
			throw new IllegalArgumentException("请先选择");
		}
		// 2.执行删除
		int rows = goodCartDao.deleteObjects(ids);
		// 3.返回结果
		return rows;
	}

	// 添加至购物车
	@Override
	public Integer insertGoodCart(GoodCart goodCart) {
		int rows = goodCartDao.insertGoodCart(goodCart);
		return rows;
	}

	@Override
	public PageObject<GoodCartVo> findPageObjects(Integer userid, Integer pageCurrent) {
		// 1.验证参数有效性
		if (pageCurrent == null || pageCurrent < 1) {
			throw new IllegalArgumentException("页码值无效");
		}
		// 2.查询总记录数并进行校验
		int rowCount = goodCartDao.getRowCount(userid);
		System.out.println(rowCount);

		// 3.查询当前页要呈现的记录
		final int pageSize = 3;
		int startIndex = (pageCurrent - 1) * pageSize;
		final List<GoodCart> records = goodCartDao.findPageObjects(userid, startIndex, pageSize);
		List<GoodCartVo> vos = new ArrayList<>();
		records.forEach(x -> {
			Good good = goodDao.findObjectById(x.getGoodid());
			vos.add(GoodCartVo.builder().id(x.getId()).discount_price(good.getDiscount_price()).name(good.getName())
					.number(x.getNumber()).userid(x.getUserid()).build());

		});
		// 4.封装查询结果并返回
		return new PageObject<>(pageCurrent, pageSize, rowCount, vos);
	}

	@Override
	public Integer updateGoodCart(GoodCart build) {
		int rows = goodCartDao.updateGoodCart(build);
		return rows;
	}

}
