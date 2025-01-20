package com.fabio.app_clientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.app_clientes.entities.Email;
import com.fabio.app_clientes.mapping.EmailMapper;
import com.fabio.app_clientes.models.EmailDTO;
import com.fabio.app_clientes.repositories.EmailRepository;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private EmailMapper emailMapper;

    public List<EmailDTO> getAllEmails(){
        List<Email> emails = emailRepository.findAll();
        return emailMapper.convertList(emails);
    }

    public EmailDTO getEmailById(Long id){
        Optional<Email> email = emailRepository.findById(id);
        return email.map(emailMapper::convert).orElse(null);
    }

    public EmailDTO saveEmail (EmailDTO emailDTO){
        Email emailE = emailMapper.convert(emailDTO);
        Email email = emailRepository.save(emailE);
        return emailMapper.convert(email);
    }

    public void deleteEmail (Long id){
        emailRepository.deleteById(id);
    }
}
