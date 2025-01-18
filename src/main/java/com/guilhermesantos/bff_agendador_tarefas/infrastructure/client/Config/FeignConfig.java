package com.guilhermesantos.bff_agendador_tarefas.infrastructure.client.Config;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig{

    @Bean
    public FeignError feignError(){
        return new FeignError();
    }
}
