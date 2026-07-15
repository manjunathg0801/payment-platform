package com.mans.payments.service.payment.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI paymentPlatformAPI() {

        return new OpenAPI()

                .info(new Info()

                        .title("Payment Platform API")

                        .description("Enterprise Payment Platform Microservice")

                        .version("1.0.0")

                        .contact(new Contact()

                                .name("Manjunath G")

                                .email("manjunath@example.com")))

                .externalDocs(new ExternalDocumentation()

                        .description("Payment Platform Documentation"));

    }

}