package com.example.adapters.in.controller;

import com.example.adapters.in.controller.mapper.CustomerMapper;
import com.example.adapters.in.controller.request.CustomerRequest;
import com.example.adapters.in.controller.response.CustomerResponse;
import com.example.application.core.domain.Customer;
import com.example.application.ports.in.DeleteCustomerInputPort;
import com.example.application.ports.in.FindCustomerInputPort;
import com.example.application.ports.in.InsertCustomerInputPort;
import com.example.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerInputPort findCustomerInputPort;
    private final DeleteCustomerInputPort deleteCustomerInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerController(
            InsertCustomerInputPort insertCustomerInputPort,
            FindCustomerInputPort findCustomerInputPort,
            DeleteCustomerInputPort deleteCustomerInputPort,
            UpdateCustomerInputPort updateCustomerInputPort,
            CustomerMapper customerMapper
    ) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerInputPort = findCustomerInputPort;
        this.deleteCustomerInputPort = deleteCustomerInputPort;
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = this.customerMapper.toCustomer(customerRequest);

        this.insertCustomerInputPort.insert(customer, customerRequest.getZipCode());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> find(@PathVariable int customerId) {
        Customer customer = this.findCustomerInputPort.find(customerId);

        CustomerResponse customerResponse = this.customerMapper.toCustomerResponse(customer);

        return ResponseEntity.ok(customerResponse);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        List<Customer> customers = this.findCustomerInputPort.findAll();

        List<CustomerResponse> customersResponse = this.customerMapper.toCustomersResponse(customers);

        return ResponseEntity.ok(customersResponse);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> delete(@PathVariable int customerId) {
        this.deleteCustomerInputPort.delete(customerId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id, @RequestBody CustomerRequest customerRequest) {
        Customer customer = this.customerMapper.toCustomer(customerRequest);
        customer.setId(id);

        this.updateCustomerInputPort.update(customer, customerRequest.getZipCode());

        return ResponseEntity.ok().build();
    }
}
