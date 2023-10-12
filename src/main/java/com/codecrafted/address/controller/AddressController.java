package com.codecrafted.address.controller;

import com.codecrafted.address.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/test")
    public String test() {
        return "API Working";
    }

    @GetMapping("/get/matching")
    public String getAddressList(@RequestParam String value) {
        return addressService.findAddress(value);
    }
}
