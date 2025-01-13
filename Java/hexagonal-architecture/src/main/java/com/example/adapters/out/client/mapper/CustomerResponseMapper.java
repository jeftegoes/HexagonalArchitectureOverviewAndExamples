package com.example.adapters.out.client.mapper;

import com.example.adapters.out.client.response.AddressResponse;
import com.example.adapters.out.repository.entities.CustomerEntity;
import com.example.application.core.domain.Address;
import com.example.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {
    CustomerEntity toCustomerEntity(Customer customer);
}
