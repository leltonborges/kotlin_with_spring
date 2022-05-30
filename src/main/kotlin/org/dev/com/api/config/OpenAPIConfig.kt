package org.dev.com.api.config

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class OpenAPIConfig {

    @Bean
    fun springOpenAPI(): OpenAPI{
        return OpenAPI()
            .info(Info().title("Spring Kotlin API")
                .description("Simple API with Spring and Security")
                .version("V1.0.0")
                .license(License().name("Apache 2.0").url("http://springdoc.org")))
            .externalDocs(ExternalDocumentation()
                .description("Spring WIKI documentation")
                .url("https://springshop.wiki.github.org/docs"))
    }
}