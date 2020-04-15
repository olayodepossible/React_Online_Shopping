package com.possible.onlinestore.models;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String role;
    private String password;
    private String confirmPassword;
    private boolean enabled = true;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;
}
