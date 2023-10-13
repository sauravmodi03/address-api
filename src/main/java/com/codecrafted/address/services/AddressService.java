package com.codecrafted.address.services;

import com.codecrafted.address.modal.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface AddressService {

    List<Address> findAddress(String value);

    List<Address> loadAll();

    Optional<Address> findById(String id);

    Page<Address> getListAddress(String value, Pageable pageable);
}
