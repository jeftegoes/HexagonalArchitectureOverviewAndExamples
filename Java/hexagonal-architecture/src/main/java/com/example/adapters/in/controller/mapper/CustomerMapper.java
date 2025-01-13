package com.example.adapters.in.controller.mapper;

import com.example.adapters.in.controller.request.CustomerRequest;
import com.example.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);
}
