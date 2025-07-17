package com.galdino.ufood.auth.core;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Getter
public class AuthUser extends User {
    private Long userId;
    private String fullName;

    public AuthUser(com.galdino.ufood.auth.domain.User domainUser) {
        super(domainUser.getEmail(), domainUser.getPassword(), Collections.emptyList());

        this.userId = domainUser.getId();
        this.fullName = domainUser.getName();
    }
}
