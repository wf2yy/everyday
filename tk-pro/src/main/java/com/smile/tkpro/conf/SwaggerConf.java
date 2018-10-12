package com.smile.tkpro.conf;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chengde
 * @create 2018/10/12 14:17
 * @desc
 */
@Configuration //spring boot配置注解
@EnableSwagger2 //启用swagger2功能注解
public class SwaggerConf {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 这里是全局扫描有@Api注解得类，还可以扫描任意位置，指定包以及针对方法上的指定注解
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户信息系统接口文档")
                .description("学生和用户接口")
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .version(" xxx ")
                .build();
    }



}

