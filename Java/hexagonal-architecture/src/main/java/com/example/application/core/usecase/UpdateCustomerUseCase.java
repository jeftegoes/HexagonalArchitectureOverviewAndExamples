package com.example.application.core.usecase;

import com.example.application.core.domain.Address;
import com.example.application.core.domain.Customer;
import com.example.application.ports.in.UpdateCustomerInputPort;
import com.example.application.ports.out.FindAddressByZipCodeOutputPort;
import com.example.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        Address address = this.findAddressByZipCodeOutputPort.find(zipCode);

        customer.setAddress(address);

        this.updateCustomerOutputPort.update(customer);
    }
}
