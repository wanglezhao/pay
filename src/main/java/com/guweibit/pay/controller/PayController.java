package com.guweibit.pay.controller;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alipay.api.AlipayApiException;
import com.guweibit.pay.service.impl.PayService;

@Controller
@RequestMapping("/pay")
public class PayController {
	@Autowired
	PayService payService;
	
	//hello测试
	@RequestMapping("/hello.do")
	public String payIndex() {
		return "hello";
	}
	//计算总价并生成订单信息并进行支付路由
	@RequestMapping("/pay.do")
	public String pay(HttpServletRequest request) {
		String name=request.getParameter("name");
		String number=request.getParameter("number");
		System.out.println(name);
		System.out.println(number);
		try {
			payService.getPayInfo(request);
			//支付路由，多种支付方式进行费率比较，选择最省钱的通道进行支付
			//本次设计只接入了支付宝沙箱支付，假设有多种支付通道则(之后有引入别的通道的话将功能放在业务层)：
			double alipay=0.9,weixinpay=0.95;
			if(alipay<weixinpay) {
				return "index";
			}else {
				return "index2";
			}
		} catch (RuntimeException e) {
			HttpSession session=request.getSession();
			session.setAttribute("exception", e.getMessage());
			return "exception";
		}
			
	}
	
	@RequestMapping("/return_url.do")
	public String pay2(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
		//返回成功或者失败的界面
		return payService.getAlipayInfo(request);
	}
}
