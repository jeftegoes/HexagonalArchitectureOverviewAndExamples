package com.example.application.ports.out;

import com.example.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer);
}
