package com.bridgelabz.zuulGatewayApplication.configuration;

import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;

import com.bridgelabz.zuulGatewayApplication.zuulFilter.Filter;
/**
 * @author bridgelabz
 * @since 9/08/2018 <br>
 *        <p>
 *        Entity giving information about the Zuul configuration <br>
 *        </p>
 */
@Configuration
public class ZuulConfig {

	@Bean
	public Filter filter() {
		return new Filter();
	}
}
