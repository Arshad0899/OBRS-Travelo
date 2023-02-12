package com.obrs.travels.dto;

import java.sql.Date;

public class PaymentDto {

	private Long cardNo;
	private String nameOncard;
	private String email;
	private String expireDate;
	private double totalPrice;

	public Long getCardNo() {
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	public String getNameOncard() {
		return nameOncard;
	}

	public void setNameOncard(String nameOncard) {
		this.nameOncard = nameOncard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public PaymentDto(Long cardNo, String nameOncard, String email, String expireDate, double totalPrice) {
		super();
		this.cardNo = cardNo;
		this.nameOncard = nameOncard;
		this.email = email;
		this.expireDate = expireDate;
		this.totalPrice = totalPrice;
	}

	public PaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
