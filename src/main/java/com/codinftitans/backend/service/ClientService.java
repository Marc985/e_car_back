package com.codinftitans.backend.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user= super.loadUser(userRequest);
        String name=user.getAttribute("name");
        String email=user.getAttribute("email");
        String pic=user.getAttribute("picture");
        String id=user.getAttribute("sub");
        Client client=new Client();

        client.setClientName(name);
        client.setClientImageUrl(pic);
        client.setClientEmail(email);


        return user;

    }


}
