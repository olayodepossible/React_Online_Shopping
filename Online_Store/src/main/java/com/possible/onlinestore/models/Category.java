package com.possible.onlinestore.models;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean active = true;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Product product;
}
