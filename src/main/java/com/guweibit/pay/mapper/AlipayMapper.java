package com.guweibit.pay.mapper;

import org.apache.ibatis.annotations.Param;

import com.guweibit.pay.entity.AlipayOrderInformation;




public interface AlipayMapper {

	/**
	 *	 插入订单数据
	 * @param ali   订单数据
	 * @return 受影响的行数
	 */
	Integer insert(AlipayOrderInformation ali);
	
	
	Integer updata(@Param("total_amount") String total_amount, 
		    @Param("status") Integer status);
}








