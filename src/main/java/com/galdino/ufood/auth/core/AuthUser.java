package com.galdino.ufood.auth.core;

import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class AuthUser extends User {
    private String fullName;

    public AuthUser(com.galdino.ufood.auth.domain.User domainUser) {
        super(domainUser.getEmail(), domainUser.getPassword(), Collections.emptyList());

        this.fullName = domainUser.getName();
    }
}
