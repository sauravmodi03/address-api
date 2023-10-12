package com.codecrafted.address.services;

import org.springframework.stereotype.Component;

@Component
public interface AddressService {

    String findAddress(String value);
}
