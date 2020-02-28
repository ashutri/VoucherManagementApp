package com.VoucherService.Software.generator;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Generator {

	@Id
	private String voucherId;
	private Long faceValue;
	private Date startDate;
	private Date expiryDate;
	private boolean redeemed;
	
	public Generator() {}

	public Generator(String voucherId, Long faceValue, Date startDate, Date expiryDate, boolean redeemed) {
		super();
		this.voucherId = voucherId;
		this.faceValue = faceValue;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.redeemed = redeemed;
	}

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public Long getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(Long faceValue) {
		this.faceValue = faceValue;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isRedeemed() {
		return redeemed;
	}

	public void setRedeemed(boolean redeemed) {
		this.redeemed = redeemed;
	}

	@Override
	public String toString() {
		return "Generator [voucherId=" + voucherId + ", faceValue=" + faceValue + ", startDate=" + startDate
				+ ", expiryDate=" + expiryDate + ", redeemed=" + redeemed + "]";
	}
	
	
	
}
