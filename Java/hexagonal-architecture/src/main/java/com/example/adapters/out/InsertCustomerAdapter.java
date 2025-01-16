package com.example.adapters.out;

import com.example.adapters.out.repository.CustomerRepository;
import com.example.adapters.out.repository.entities.CustomerEntity;
import com.example.adapters.out.repository.mapper.CustomerEntityMapper;
import com.example.application.core.domain.Customer;
import com.example.application.ports.out.InsertCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {
    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public InsertCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = this.customerEntityMapper.toCustomerEntity(customer);

        this.customerRepository.save(customerEntity);
    }
}
