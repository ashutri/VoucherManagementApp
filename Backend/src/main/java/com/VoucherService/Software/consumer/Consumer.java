package com.VoucherService.Software.consumer;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Consumer {
    @Id
	private Long id;
	private Long mobile;
	private String voucherId;
	
	public Consumer() 
	{}
	
	public Consumer(Long id, Long mobile, String voucherId) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.voucherId = voucherId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}
	
	
	
}
