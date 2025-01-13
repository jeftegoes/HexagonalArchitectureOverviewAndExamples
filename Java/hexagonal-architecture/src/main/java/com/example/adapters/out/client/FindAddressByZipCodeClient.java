package com.example.adapters.out.client;

import com.example.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${client.address}")
public interface FindAddressByZipCodeClient {
    @GetMapping("/{zipCode}/json/")
    AddressResponse getCep(@PathVariable String zipCode);
}
