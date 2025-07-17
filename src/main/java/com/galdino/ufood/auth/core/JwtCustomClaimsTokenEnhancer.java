package com.galdino.ufood.auth.core;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;

public class JwtCustomClaimsTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        if (oAuth2Authentication.getPrincipal() instanceof AuthUser) {
            AuthUser authUser = (AuthUser) oAuth2Authentication.getPrincipal();

            HashMap<String, Object> info = new HashMap<>();
            info.put("full_name", authUser.getFullName());
            info.put("user_id", authUser.getUserId());

            DefaultOAuth2AccessToken defaultOAuth2AccessToken = (DefaultOAuth2AccessToken) oAuth2AccessToken;
            defaultOAuth2AccessToken.setAdditionalInformation(info);
        }

        return oAuth2AccessToken;
    }
}
