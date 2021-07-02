package com.hallbooking.admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminSupervisorSerivcesApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdminSupervisorSerivcesApplication.class, args);
	}
	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.hallbooking.admin"))
				.paths(PathSelectors.any())
				.build();
	}
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder().title("Admin Supervisor Service API")
				.description("Admin Supervisor Service In Marriage Hall Booking Application")
				.termsOfServiceUrl("http://hallbooking.com")
				.license("service provider")
				.licenseUrl("mangeshpotdar87@gmail.com")
				.version("1.0")
				.build();		
	}
	
	@Bean("rtemp")
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
