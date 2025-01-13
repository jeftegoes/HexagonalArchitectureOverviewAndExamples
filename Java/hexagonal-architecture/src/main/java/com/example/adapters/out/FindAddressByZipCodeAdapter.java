package com.example.adapters.out;

import com.example.adapters.out.client.FindAddressByZipCodeClient;
import com.example.adapters.out.client.mapper.AddressResponseMapper;
import com.example.adapters.out.client.response.AddressResponse;
import com.example.application.core.domain.Address;
import com.example.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {
    private final FindAddressByZipCodeClient findAddressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;

    @Autowired
    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient findAddressByZipCodeClient, AddressResponseMapper addressResponseMapper) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = this.findAddressByZipCodeClient.getCep(zipCode);
        Address address = addressResponseMapper.toAddress(addressResponse);
        return address;
    }
}
