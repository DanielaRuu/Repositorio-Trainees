package com.mx.proyectofinal.cuentasBancoMex.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuration class to add properties related to API de cuentas bancarias
 */
@Configuration
public class OpenApiConfiguration {
    /**
     * Property to get server in DEV environment.
     */
    @Value("${bankAccounts.openapi.dev-url}")
    private String devUrl;

    /**
     * Method to create the Bean of OpenAPI documentation.
     * @return an OpenAPI object.
     */
    @Bean
    public OpenAPI bankAccountsOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("dsruiz11@gmail.com");
        contact.setName("Daniela Salmeron Ruiz");

        License apacheLicense = new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html");

        Info info = new Info()
                .title("Api de cuentas bancarias")
                .version("1.0")
                .contact(contact)
                .description("API para consultar informacion de cuentas de BancoMex")
                .license(apacheLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
