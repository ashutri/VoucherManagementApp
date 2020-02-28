package com.VoucherService.Software.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VoucherService.Software.generator.Generator;
import com.VoucherService.Software.generator.GeneratorDao;

@RestController
@RequestMapping("/api/admin/create")
public class GeneratorController {
	
	@Autowired
	private GeneratorDao genService;
	
	@Autowired
	private Generator generator;

	GeneratorController() {
	}
	
	

	@GetMapping(value = "/voucherList")
	public List<Generator> getVouchers() {
		return genService.findAll();
	}
	
    @PostMapping("/getVoucher")
	public void generateVoucher(@RequestBody Integer number)
	{  
		genService.createVouchers(number);
		
	}
}
