package com.example.application.ports.in;

import com.example.application.core.domain.Customer;

public interface CustomerInputPort {
    void insert(Customer customer, String zipCode);
}
