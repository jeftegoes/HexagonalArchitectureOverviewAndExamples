package com.example.adapters.out.client.mapper;

import com.example.adapters.out.client.response.AddressResponse;
import com.example.application.core.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    @Mapping(source = "logradouro", target = "street")
    @Mapping(source = "localidade", target = "city")
    @Mapping(source = "estado", target = "state")
    Address toAddress(AddressResponse addressResponse);
}
