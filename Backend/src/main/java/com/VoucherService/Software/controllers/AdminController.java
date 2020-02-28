package com.VoucherService.Software.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VoucherService.Software.generator.Generator;
import com.VoucherService.Software.generator.GeneratorDao;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

	@Autowired
	private GeneratorDao genService;
	
	@Autowired
	private Generator generator;
	
	AdminController() {
	}
	

	@GetMapping(value = "/voucherList")
	public List<Generator> getVouchers() {
		return genService.findAll();
	}
}
