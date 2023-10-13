package com.codecrafted.address.services;

import com.codecrafted.address.modal.Address;
import com.codecrafted.address.repository.AddressRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;


    /**
     * @param value
     * @return
     */
    @Override
    public List<Address> findAddress(String value) {
        return addressRepository.findAddressByFullStreetContainingIgnoreCaseOrFullStreetAbrContainingIgnoreCase(value.trim(), value.trim());
    }

    @Override
    public List<Address> loadAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(String id) {
        return addressRepository.findById(id);
    }

    @Override
    public Page<Address> getListAddress(String value, Pageable pageable) {
        return addressRepository.getAddressesByFullStreetAbrContainingIgnoreCaseOrFullStreetAbrContainsIgnoreCase(value,value,  pageable);
    }
}
