package com.galdino.ufood.auth.core;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class AuthUser extends User {
    private Long userId;
    private String fullName;

    public AuthUser(com.galdino.ufood.auth.domain.User domainUser, Collection<? extends GrantedAuthority> authorities) {
        super(domainUser.getEmail(), domainUser.getPassword(), authorities);

        this.userId = domainUser.getId();
        this.fullName = domainUser.getName();
    }
}
