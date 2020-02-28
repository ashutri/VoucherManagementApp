package com.VoucherService.Software.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VoucherService.Software.Authentication.Authentication;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/login")
public class AuthController {

	@GetMapping(path = "/basicauth")
    public Authentication basicauth() {
        return new Authentication("You are authenticated");
    }
}
