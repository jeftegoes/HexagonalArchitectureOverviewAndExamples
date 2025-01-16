package com.example.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private int id;
    private String name;
    private AddressResponse address;
}
