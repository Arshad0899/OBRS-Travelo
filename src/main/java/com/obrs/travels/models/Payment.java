package com.obrs.travels.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	@Column(nullable = false)
	private Long cardNo;
	@Column(nullable = false)
	private String nameOncard;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String expireDate;
	@Column(nullable = false)
	private double totalPrice;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

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

	public Payment(Integer paymentId, Long cardNo, String nameOncard, String email, String expireDate,
			double totalPrice) {
		super();
		this.paymentId = paymentId;
		this.cardNo = cardNo;
		this.nameOncard = nameOncard;
		this.email = email;
		this.expireDate = expireDate;
		this.totalPrice = totalPrice;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

}
