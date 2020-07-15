package com.kamlesh.springbootswagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpringbootSwagger2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwagger2Application.class, args);
    }

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.kamlesh"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Address book API",
                "Sample API",
                "0.1",
                "Open Source",
                new Contact("Kamlesh Silag","kamleshsilag.github.io","abc@gmail.com"),
                "API Licence",
                "kamleshsilag.github.io",
                Collections.emptyList()
        );
    }

}
