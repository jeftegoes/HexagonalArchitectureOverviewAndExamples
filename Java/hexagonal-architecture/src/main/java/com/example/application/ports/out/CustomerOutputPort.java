package com.example.application.ports.out;

import com.example.application.core.domain.Customer;

public interface CustomerOutputPort {
    void insert(Customer customer);
}
