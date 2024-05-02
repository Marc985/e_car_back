package com.codinftitans.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ClientInfo {

    @GetMapping("/info")
   /*public  Client getUserInfo(@AuthenticationPrincipal OAuth2User principal){
        String name=principal.getAttribute("name");
        String email=principal.getAttribute("email");
        String id=principal.getAttribute("sub");
        String pic=principal.getAttribute("picture");
        Client client=new Client();
        client.setIdClient(id);
        client.setEmail(email);
        client.setClientName(name);
        client.setProfilPic(pic);
        return client;
    }*/
    public String hello (){
        return  "hello";
    }


}
