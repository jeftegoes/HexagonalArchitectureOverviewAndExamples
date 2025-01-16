package com.example.config;

import com.example.adapters.out.DeleteCustomerAdapter;
import com.example.adapters.out.FindAddressByZipCodeAdapter;
import com.example.adapters.out.InsertCustomerAdapter;
import com.example.application.core.usecase.DeleteCustomerUseCase;
import com.example.application.core.usecase.FindCustomerUseCase;
import com.example.application.core.usecase.InsertCustomerUseCase;
import com.example.application.ports.out.FindCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            DeleteCustomerAdapter deleteCustomerAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
    }

    @Bean
    public FindCustomerUseCase findCustomerUseCase(
            FindCustomerOutputPort findCustomerOutputPort
    ) {
        return new FindCustomerUseCase(findCustomerOutputPort);
    }

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(DeleteCustomerAdapter deleteCustomerAdapter) {
        return new DeleteCustomerUseCase(deleteCustomerAdapter);
    }
}
