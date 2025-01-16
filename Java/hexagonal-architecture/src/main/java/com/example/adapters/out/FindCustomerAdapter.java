package com.example.adapters.out;

import com.example.adapters.out.repository.mapper.CustomerEntityMapper;
import com.example.adapters.out.repository.CustomerRepository;
import com.example.adapters.out.repository.entities.CustomerEntity;
import com.example.application.core.domain.Customer;
import com.example.application.ports.out.FindCustomerOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FindCustomerAdapter implements FindCustomerOutputPort {
    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> find(int customerId) {
        Optional<CustomerEntity> customerEntity = this.customerRepository.findById(customerId);

        Optional<Customer> customer = customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));

        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> customerEntity = this.customerRepository.findAll();

        List<Customer> customers = customerEntityMapper.toCustomers(customerEntity);

        return customers;
    }
}
