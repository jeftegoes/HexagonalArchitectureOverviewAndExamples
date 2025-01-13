package com.example.adapters.out.client.mapper;

import com.example.adapters.out.client.response.AddressResponse;
import com.example.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
