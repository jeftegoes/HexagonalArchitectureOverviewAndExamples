package com.example.application.core.usecase;

import com.example.application.core.domain.Address;
import com.example.application.core.domain.Customer;
import com.example.application.ports.in.CustomerInputPort;
import com.example.application.ports.out.CustomerOutputPort;
import com.example.application.ports.out.FindAddressByZipCodeOutputPort;

public class CustomerUseCase implements CustomerInputPort {
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final CustomerOutputPort customerOutputPort;

    public CustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, CustomerOutputPort customerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.customerOutputPort = customerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = this.findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        this.customerOutputPort.insert(customer);
    }
}
