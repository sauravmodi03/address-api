package com.codecrafted.address.modal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "street_no")
    private String streetNo;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "city")
    private String city;

    @Column(name = "state_code")
    private String stateCode;

    @Column(name = "state")
    private String state;

    @Column(name = "postcode")
    private int postcode;

    @Column(name = "full_street")
    private String fullStreet;

    @Column(name = "full_street_abr")
    private String fullStreetAbr;

    @Column(name = "lat")
    private String latitude;

    @Column(name = "long")
    private String longitude;
}
