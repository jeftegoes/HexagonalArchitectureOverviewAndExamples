package com.example.application.ports.in;

import com.example.application.core.domain.Customer;

import java.util.List;

public interface FindCustomerInputPort {
    Customer find(int customerId);

    List<Customer> findAll();
}
