package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.Mail;
import com.codinftitans.backend.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMailController {
    @Autowired
    MailService email;

    @PostMapping("/mail")
    public ResponseEntity<String> sendEmail(@RequestBody Mail mail) {
        email.sendMessage(mail.getTo(), mail.getSubject(), mail.getText());
        return ResponseEntity
                .ok().body("ok");


    }
}
