package com.VoucherService.Software.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VoucherService.Software.consumer.ConsumerDao;
import com.VoucherService.Software.generator.Generator;

@RestController
@RequestMapping(value = "/api/merchant")
public class MerchantController {

	@Autowired
	private ConsumerDao conService;
	
		
	@GetMapping(value = "/{voucherId}")
	public String redeemVoucher(@PathVariable String voucherId) {
		return conService.redeemId(voucherId);
	}
}
