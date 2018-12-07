package com.guweibit.pay.mapper;


import com.guweibit.pay.entity.Commodity;



public interface CommodityMapper {


	/**
	 * 	通过商品名称得到商品信息
	 * @param name
	 * @return 商品信息
	 */
	Commodity getCommodityByName(String name);

	

	
}








