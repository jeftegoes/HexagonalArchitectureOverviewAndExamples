package com.example.config;

import com.example.adapters.out.*;
import com.example.application.core.usecase.DeleteCustomerUseCase;
import com.example.application.core.usecase.FindCustomerUseCase;
import com.example.application.core.usecase.InsertCustomerUseCase;
import com.example.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
    }

    @Bean
    public FindCustomerUseCase findCustomerUseCase(
            FindCustomerAdapter findCustomerAdapter
    ) {
        return new FindCustomerUseCase(findCustomerAdapter);
    }

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(
            DeleteCustomerAdapter deleteCustomerAdapter
    ) {
        return new DeleteCustomerUseCase(deleteCustomerAdapter);
    }

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
