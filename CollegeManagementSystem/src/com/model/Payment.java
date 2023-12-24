package com.model;

public class Payment {
	
	private String paymentId;
	private String enrollmentId;
	private String paymentDate;
	private String paymentModule;
	private double amount;
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentModule() {
		return paymentModule;
	}
	public void setPaymentModule(String paymentModule) {
		this.paymentModule = paymentModule;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Payment(String paymentId, String enrollmentId, String paymentDate, String paymentModule, double amount) {
		super();
		this.paymentId = paymentId;
		this.enrollmentId = enrollmentId;
		this.paymentDate = paymentDate;
		this.paymentModule = paymentModule;
		this.amount = amount;
	}
}
