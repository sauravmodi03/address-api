package com.codecrafted.address.services;

import com.codecrafted.address.modal.Address;
import com.codecrafted.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

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
        String searchParam = value.replaceAll("\\s","");
        return addressRepository.findDistinctByFullStreetContainsIgnoreCaseOrFullStreetAbrContainsIgnoreCase(searchParam, searchParam, pageable);
    }
}
