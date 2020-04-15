package com.possible.onlinestore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //private User user;
    private String billingAddress;
    private String shippingAddress;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private boolean shipping;
    private boolean billing;
}
