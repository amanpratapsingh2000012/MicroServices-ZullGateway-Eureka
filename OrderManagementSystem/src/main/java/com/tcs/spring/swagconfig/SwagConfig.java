package com.tcs.spring.swagconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.ImmutableList;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwagConfig {
	 public Docket patientManagementSystemApi() {

	        Docket docket = new Docket(DocumentationType.SWAGGER_2);

	        docket.groupName("pms-api").select().apis(RequestHandlerSelectors.any())
	        .paths(PathSelectors.ant("/api*")).paths(PathSelectors.ant("/facility*")).build();

	        docket.globalResponseMessage(RequestMethod.GET,
	                ImmutableList.of(
	                        new ResponseMessageBuilder().code(400).message("Bad Request")
	                                .responseModel(new ModelRef("Error")).build(),
	                        new ResponseMessageBuilder().code(500).message("Internal Server Error")
	                                .responseModel(new ModelRef("Error")).build()));
	        return docket;
	    }
}
