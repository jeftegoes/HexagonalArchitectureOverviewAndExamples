package com.example.adapters.in.controller;

import com.example.adapters.in.controller.mapper.CustomerMapper;
import com.example.adapters.in.controller.request.CustomerRequest;
import com.example.application.core.domain.Customer;
import com.example.application.ports.in.CustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerInputPort customerInputPort;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerInputPort customerInputPort, CustomerMapper customerMapper) {
        this.customerInputPort = customerInputPort;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = this.customerMapper.toCustomer(customerRequest);
        String zipCode = customerRequest.getZipCode();

        this.customerInputPort.insert(customer, zipCode);

        return ResponseEntity.ok().build();
    }
}
