package fr.jorisrouziere.animauxapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Animaux API").description("L'api Animaux regroupe une collection complète d'animaux et vous permet de les gérer facilement.\n" +
                "\n" +
                "Cette API prend en charge le type de média JSON et utilise le codage de caractères UTF-8.\n" +
                "\n" +
                "Elle est actuellement reliée à l'application de fiche Animal créé sous Android [Lien du GIT](https://github.com/Joktaa/Animaux)")
                .version("V1.0"). build();
    }

}