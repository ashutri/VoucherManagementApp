package com.VoucherService.Software.vouchergenerationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication(scanBasePackages="com.VoucherService.Software")
@EnableWebSecurity
public class VoucherGenerationServiceApplication extends WebSecurityConfigurerAdapter{

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().
        disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }
	public static void main(String[] args) {
		SpringApplication.run(VoucherGenerationServiceApplication.class, args);
		
	}

}
