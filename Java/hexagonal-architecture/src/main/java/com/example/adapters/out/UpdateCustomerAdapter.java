package com.example.adapters.out;

import com.example.adapters.out.repository.CustomerRepository;
import com.example.adapters.out.repository.entity.CustomerEntity;
import com.example.adapters.out.repository.mapper.CustomerEntityMapper;
import com.example.application.core.domain.Customer;
import com.example.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void update(Customer customer) {
        CustomerEntity customerEntity = this.customerEntityMapper.toCustomerEntity(customer);

        this.customerRepository.save(customerEntity);
    }
}
