package com.example.adapters.out;

import com.example.adapters.out.client.mapper.CustomerResponseMapper;
import com.example.adapters.out.repository.CustomerRepository;
import com.example.adapters.out.repository.entities.CustomerEntity;
import com.example.application.core.domain.Customer;
import com.example.application.ports.out.CustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class CustomerAdapter implements CustomerOutputPort {
    private final CustomerRepository customerRepository;
    private final CustomerResponseMapper customerResponseMapper;

    public CustomerAdapter(CustomerRepository customerRepository, CustomerResponseMapper customerResponseMapper) {
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
    }

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = this.customerResponseMapper.toCustomerEntity(customer);

        this.customerRepository.save(customerEntity);
    }
}
