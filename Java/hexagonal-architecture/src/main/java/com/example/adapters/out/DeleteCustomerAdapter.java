package com.example.adapters.out;

import com.example.adapters.out.repository.CustomerRepository;
import com.example.application.ports.out.DeleteCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerAdapter implements DeleteCustomerOutputPort {
    private final CustomerRepository customerRepository;

    public DeleteCustomerAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void delete(int customerId) {
        this.customerRepository.deleteById(customerId);
    }
}
