package com.guweibit.pay.entity;

public class AlipayOrderInformation {
	private Double outTradeNo;
	private String subject;
	private String totalAmount;
	private String body;
	private Integer status;
	
	public AlipayOrderInformation(Double outTradeNo, String subject, String totalAmount, String body) {
		super();
		this.outTradeNo = outTradeNo;
		this.subject = subject;
		this.totalAmount = totalAmount;
		this.body = body;
	}

	public String toString() {
		return "AlipayOrderInformation [outTradeNo=" + outTradeNo + ", subject=" + subject + ", totalAmount="
				+ totalAmount + ", body=" + body + ", status=" + status + "]";
	}

	public Double getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(Double outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	

}
