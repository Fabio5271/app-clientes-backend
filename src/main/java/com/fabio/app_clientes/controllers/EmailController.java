package com.fabio.app_clientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.app_clientes.models.EmailDTO;
import com.fabio.app_clientes.services.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmailDTO>> getAllEmails() {
        return new ResponseEntity<>(
            emailService.getAllEmails(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/{emailId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmailDTO> getEmailById(@PathVariable Long emailId) {
        EmailDTO emailDTO = emailService.getEmailById(emailId);
        if (emailDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emailDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmailDTO> createEmail(@RequestBody EmailDTO emailDTO) {
        EmailDTO newEmailDTO = emailService.saveEmail(emailDTO);
        return new ResponseEntity<>(newEmailDTO, HttpStatus.CREATED);
    }
    
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmailDTO> updateEmail(@RequestBody EmailDTO emailDTO) {
        EmailDTO updEmailDTO = emailService.saveEmail(emailDTO);
        return new ResponseEntity<>(updEmailDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{emailId}")
    public ResponseEntity<Object> deleteEmail(@PathVariable Long emailId) {
        emailService.deleteEmail(emailId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
