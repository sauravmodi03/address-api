package com.codecrafted.address.controller;

import com.codecrafted.address.modal.Address;
import com.codecrafted.address.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/test")
    public String test() {
        return "API Working";
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Address>> loadAll() {
        return new ResponseEntity<>(addressService.loadAll(), HttpStatus.OK);
    }

    @GetMapping("/get/listaddress")
    public ResponseEntity<List<Address>> getListAddress(@RequestParam String searchParam,
                                                        @DefaultValue("0") @RequestParam int pageNo,
                                                        @DefaultValue("20") @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new ResponseEntity<>(addressService.getListAddress(searchParam, pageable).getContent(), HttpStatus.OK);
    }
    @GetMapping("/get/address")
    public ResponseEntity<Optional<Address>> getAddress(@RequestParam String id) {
        return new ResponseEntity<>(addressService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/error")
    public String errorOccurred() {
        return "Error Occurred";
    }

}
