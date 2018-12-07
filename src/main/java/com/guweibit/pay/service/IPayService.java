package com.guweibit.pay.service;

import javax.servlet.http.HttpServletRequest;

import com.guweibit.pay.entity.AlipayOrderInformation;

public interface IPayService {
	AlipayOrderInformation getPayInfo(HttpServletRequest request);
}
