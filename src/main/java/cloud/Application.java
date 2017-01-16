package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by lijc on 15/8/27.
 */
@Configuration
//@ComponentScan
@EnableSwagger2
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(regex(".*?[^error]"))
                .build();
    }

//    @Bean
//    SecurityContext securityContext() {
//        AuthorizationScope readScope = new AuthorizationScope("read:pets", "read your pets");
//        AuthorizationScope[] scopes = new AuthorizationScope[1];
//        scopes[0] = readScope;
//        SecurityReference securityReference = SecurityReference.builder()
//                .reference("petstore_auth")
//                .scopes(scopes)
//                .build();
//
//        return SecurityContext.builder()
//                .securityReferences(newArrayList(securityReference))
//                .forPaths(ant("/api/pet.*"))
//                .build();
//    }
//
//    List<AuthorizationScope> scopes() {
//        return newArrayList(
//                new AuthorizationScope("write:pets", "modify pets in your account"),
//                new AuthorizationScope("read:pets", "read your pets"));
//    }
//
//    @Bean
//    public SecurityConfiguration securityInfo() {
//        return new SecurityConfiguration("abc", "123", "pets", "petstore", "123", ApiKeyVehicle.HEADER, ",");
//    }
//
//    List<GrantType> grantTypes() {
//        GrantType grantType = new ImplicitGrantBuilder()
//                .loginEndpoint(new LoginEndpoint("http://petstore.swagger.io/api/oauth/dialog"))
//                .build();
//        return newArrayList(grantType);
//    }
//
//    @Bean
//    SecurityScheme oauth() {
//        return new OAuthBuilder()
//                .name("petstore_auth")
//                .grantTypes(grantTypes())
//                .scopes(scopes())
//                .build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Qiniu API")
                .description("API program for Qiniu cloud service")
                .contact("Lijc")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }

}
