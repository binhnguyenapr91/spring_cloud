package me.toam.springcloud.eurekaclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author: Binh Nguyen Thai
 *
 * Sep 07, 2020
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    private final String basePackage = "vn.com.vndirect.demospringcloudeurekaclient.api";

    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metadata())
                .tags(
                        new Tag("APIs account", "APIs account"));

    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Demo Eureka Client Service API documentation")
                .description("This is API documentation for working with SAS Platform")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("Binh Nguyen","", "binhnguyen.apr91@gmail.com"))
                .build();
    }
}
