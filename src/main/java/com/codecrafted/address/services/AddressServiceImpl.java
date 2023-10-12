package com.codecrafted.address.services;

import com.codecrafted.address.modal.Address;
import com.codecrafted.address.repository.AddressRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    private final Gson gson = new Gson();

    /**
     * @param value
     * @return
     */
    @Override
    public String findAddress(String value) {
        return gson.toJson(addressRepository.findAddressByFullStreet(value));
    }
}
