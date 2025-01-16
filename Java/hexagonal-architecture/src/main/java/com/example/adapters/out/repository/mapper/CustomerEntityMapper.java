package com.example.adapters.out.repository.mapper;

import com.example.adapters.out.repository.entity.CustomerEntity;
import com.example.application.core.domain.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    Customer toCustomer(CustomerEntity customerEntity);

    List<Customer> toCustomers(List<CustomerEntity> customerEntity);

    CustomerEntity toCustomerEntity(Customer customer);
}
