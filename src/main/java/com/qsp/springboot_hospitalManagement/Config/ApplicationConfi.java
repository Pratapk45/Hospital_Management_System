package com.qsp.springboot_hospitalManagement.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// URL of Swagger : http://localHost:8080/swagger-ui.html#
//Add Dependancy : Swagger2 and swagger UI 
@Configuration
@EnableSwagger2
public class ApplicationConfi {
	
	@Bean
	public Docket getDocket()
	{
		Contact contact = new Contact("Qspiders","https://qspiders.com", "pratapkachare45@gmail.com");
		List<VendorExtension> extension = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("Hospital Management System","This app is used to maintain and manage the details of the patient in an Hospital",
				        "Version1.0 ","1 year of free service",contact ,"QSP001","http://qsp001.com", extension);
	     
	return new Docket(DocumentationType.SWAGGER_2).select()
	    .apis(RequestHandlerSelectors.basePackage("com.qsp.springboot_hospitalManagement"))
	    .build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}

}
