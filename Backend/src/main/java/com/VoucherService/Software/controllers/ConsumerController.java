package com.VoucherService.Software.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VoucherService.Software.consumer.Consumer;
import com.VoucherService.Software.consumer.ConsumerDao;
import com.VoucherService.Software.consumer.ConsumerInfo;
import com.VoucherService.Software.generator.Generator;
import com.VoucherService.Software.generator.GeneratorDao;

@RestController
@RequestMapping(value = "/api/consumer")
public class ConsumerController {

	@Autowired
	private GeneratorDao genService;
	
	
	@Autowired
	private ConsumerDao conService;		
	
	
	@GetMapping(value = "/consumerList/{mobile}")
	public List<Generator> findConsumer(@PathVariable Long mobile) {
		return conService.findConsumer(mobile);
	}
	
	@PostMapping(value = "/addNumber")
	public void addConsumer(@RequestBody ConsumerInfo conInfo) {
		
		conService.insertConsumer(conInfo);
	}
}
