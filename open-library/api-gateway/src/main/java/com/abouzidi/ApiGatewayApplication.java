package com.abouzidi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.abouzidi.configuration.RibbonConfiguration;

/**
 * @author Afif Bouzidi
 *
 */
@EnableEurekaClient
@EnableZuulProxy
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		 new SpringApplicationBuilder(ApiGatewayApplication.class).run(args);
	}
}
