package com.example.adapters.in.controller.mapper;

import com.example.adapters.in.controller.request.CustomerRequest;
import com.example.adapters.in.controller.response.CustomerResponse;
import com.example.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);

    List<CustomerResponse> toCustomersResponse(List<Customer> customer);
}
