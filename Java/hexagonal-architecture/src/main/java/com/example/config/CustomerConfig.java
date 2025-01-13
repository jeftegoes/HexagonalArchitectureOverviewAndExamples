package com.example.config;

import com.example.adapters.out.CustomerAdapter;
import com.example.adapters.out.FindAddressByZipCodeAdapter;
import com.example.application.core.usecase.CustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Bean
    public CustomerUseCase customerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            CustomerAdapter customerAdapter
    ) {
        return new CustomerUseCase(findAddressByZipCodeAdapter, customerAdapter);
    }
}
