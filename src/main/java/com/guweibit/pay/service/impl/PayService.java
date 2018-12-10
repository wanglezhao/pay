package com.guweibit.pay.service.impl;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.guweibit.pay.config.AlipayConfig;
import com.guweibit.pay.entity.AlipayOrderInformation;
import com.guweibit.pay.entity.Commodity;
import com.guweibit.pay.mapper.AlipayMapper;
import com.guweibit.pay.mapper.CommodityMapper;
import com.guweibit.pay.service.IPayService;
import com.guweibit.pay.service.ex.NameNotFoundException;
@Service("payService")
public class PayService implements IPayService{
	@Autowired
	private CommodityMapper  commodityMapper;
	
	@Autowired
	private AlipayMapper alipayMapper;
	
	private Integer insertInfo(AlipayOrderInformation ali) {
		return alipayMapper.insert(ali);
	}
	
	private Commodity getCommodityInfoByName(String name) {
		return commodityMapper.getCommodityByName(name);
	}
	
	//计算总价并生成订单信息存入数据库中
	public AlipayOrderInformation getPayInfo (HttpServletRequest request) {
		String name=request.getParameter("name");
		Integer number=Integer.parseInt(request.getParameter("number"));
		Commodity commodity=getCommodityInfoByName(name);
		if(commodity!=null) {
			String TotalAmount=Integer.toString(commodity.getPrice()*number)+".00";
			request.getSession();
			//生成订单号
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			System.out.println(df.format(new Date()));
			AlipayOrderInformation ali=new AlipayOrderInformation(Double.parseDouble(df.format(new Date())), "商品", TotalAmount, "这是一个商品");
			//将订单信息插入数据库
			insertInfo(ali);
			return ali;
		}else {
			// 错误：抛出PasswordNotMatchException
			throw new NameNotFoundException("该商品不存在！");
		}
		
		
	}
	//获取支付宝回复信息
	public String getAlipayInfo(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
		//获取支付宝GET过来反馈信息
		String status=null;
				Map<String,String> params = new HashMap<String,String>();
				Map<String,String[]> requestParams = request.getParameterMap();
				for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
					String name = (String) iter.next();
					String[] values = (String[]) requestParams.get(name);
					String valueStr = "";
					for (int i = 0; i < values.length; i++) {
						valueStr = (i == values.length - 1) ? valueStr + values[i]
								: valueStr + values[i] + ",";
					}
					//乱码解决，这段代码在出现乱码时使用
					valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
					params.put(name, valueStr);
				}
				boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
				if(signVerified) {
					//商户订单号
					String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
					//支付宝交易号
					String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
					//付款金额
					String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
					alipayMapper.updata(total_amount, 1);
					status="success";
					System.out.println("购买成功！trade_no:"+trade_no+"out_trade_no:"+out_trade_no+"total_amount:"+total_amount);
				}else {
					System.out.println("验签失败");
					status="fail";
				}
				return status;
			
	}
}
