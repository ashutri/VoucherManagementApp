package com.VoucherService.Software.consumer;

import org.springframework.stereotype.Component;

@Component
public class ConsumerInfo {
	
	private Long mobile;
	private String[] vArray;
	
	public ConsumerInfo()
	{}
	
	public ConsumerInfo(Long mobile, String[] vArray) {
		super();
		this.mobile = mobile;
		this.vArray = vArray;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String[] getvArray() {
		return vArray;
	}

	public void setvArray(String[] vArray) {
		this.vArray = vArray;
	}
	
	
}
