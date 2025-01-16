package com.example.application.ports.out;

import com.example.application.core.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface FindCustomerOutputPort {
    Optional<Customer> find(int customerId);

    List<Customer> findAll();
}
