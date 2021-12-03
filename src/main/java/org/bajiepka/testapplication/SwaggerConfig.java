package org.bajiepka.testapplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerApiConfig (){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                //.apis(RequestHandlerSelectors.basePackage("org.bajiepka.testapplication"))
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Swagger API Test Application by Broccolina13",
                "Utility calculation app",
                "1.0.0",
                "Public API",
                new Contact(
                        "Broccolina13",
                        "https://github.com/Broccolina13",
                        "boyarskaya-m@inbox.ru"),
                "API License Open",
                "https://github.com/Broccolina13/testapplication",
                Collections.emptyList());
    }

}
