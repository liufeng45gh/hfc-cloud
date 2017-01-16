//package cloud.config;
//
//import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
//import com.mangofactory.swagger.models.dto.ApiInfo;
//import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Created by lijc on 15/8/27.
// */
//@Configuration
//@EnableAutoConfiguration
//public class SwaggerConfig {
//    private SpringSwaggerConfig springSwaggerConfig;
//
//    @Autowired
//    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
//        this.springSwaggerConfig = springSwaggerConfig;
//    }
//
//    @Bean
//    // Don't forget the @Bean annotation
//    public SwaggerSpringMvcPlugin customImplementation() {
//        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
//                apiInfo()).includePatterns(".*?").swaggerGroup("my-group");
//    }
//    private ApiInfo apiInfo() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Qiniu API",
//                "API for Qiniu",
//                "Qiniu API terms of service",
//                null,
//                null,
//                null);
//        return apiInfo;
//    }
//}
