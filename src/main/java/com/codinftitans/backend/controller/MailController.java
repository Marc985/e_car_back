package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.Mail;
import com.codinftitans.backend.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {
    @Autowired
    MailService mailService;
    @PostMapping("/mail")
    public String sendMail( @RequestBody Mail mail){
   return   mailService.sendMessage(mail.getFrom(),mail.getText())   ;
    }



}
