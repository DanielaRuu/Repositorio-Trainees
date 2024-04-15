package com.mx.proyectofinal.cuentasBancoMex.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankAccountsConfiguration {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
