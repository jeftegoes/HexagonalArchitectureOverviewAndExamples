package com.example.application.core.usecase;

import com.example.application.core.domain.Customer;
import com.example.application.ports.in.FindCustomerInputPort;
import com.example.application.ports.out.FindCustomerOutputPort;

import java.util.List;

public class FindCustomerUseCase implements FindCustomerInputPort {
    private final FindCustomerOutputPort findCustomerOutputPort;

    public FindCustomerUseCase(FindCustomerOutputPort findCustomerOutputPort) {
        this.findCustomerOutputPort = findCustomerOutputPort;
    }

    @Override
    public Customer find(int customerId) {
        return this.findCustomerOutputPort.find(customerId).orElseThrow(() -> new RuntimeException("Customer not found!"));
    }

    @Override
    public List<Customer> findAll() {
        return this.findCustomerOutputPort.findAll();
    }
}
