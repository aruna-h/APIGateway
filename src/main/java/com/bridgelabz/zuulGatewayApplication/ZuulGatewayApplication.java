package com.bridgelabz.zuulGatewayApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.bridgelabz.zuulGatewayApplication.zuulFilter.Filter;
/**
 * @author bridgelabz
 * @since 9/08/2018 <br>
 *        <p>
 *        Entity giving information about the Zuul api-GatewayApplication <br>
 *        </p>
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
	
}
