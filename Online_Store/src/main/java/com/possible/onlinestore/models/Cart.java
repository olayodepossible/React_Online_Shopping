package com.possible.onlinestore.models;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;
    private double grandTotal;
    private int cartLines;
}
