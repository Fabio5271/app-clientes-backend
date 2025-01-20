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

import com.fabio.app_clientes.models.TelefoneDTO;
import com.fabio.app_clientes.services.TelefoneService;

@RestController
@RequestMapping("/api/telefone")
public class TelefoneController {
    @Autowired
    private TelefoneService telefoneService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TelefoneDTO>> getAllTelefones() {
        return new ResponseEntity<>(
            telefoneService.getAllTelefones(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/{telefoneId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TelefoneDTO> getTelefoneById(@PathVariable Long telefoneId) {
        TelefoneDTO telefoneDTO = telefoneService.getTelefoneById(telefoneId);
        if (telefoneDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(telefoneDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TelefoneDTO> createTelefone(@RequestBody TelefoneDTO telefoneDTO) {
        TelefoneDTO newTelefoneDTO = telefoneService.saveTelefone(telefoneDTO);
        return new ResponseEntity<>(newTelefoneDTO, HttpStatus.CREATED);
    }
    
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TelefoneDTO> updateTelefone(@RequestBody TelefoneDTO telefoneDTO) {
        TelefoneDTO updTelefoneDTO = telefoneService.saveTelefone(telefoneDTO);
        return new ResponseEntity<>(updTelefoneDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{telefoneId}")
    public ResponseEntity<Object> deleteTelefone(@PathVariable Long telefoneId) {
        telefoneService.deleteTelefone(telefoneId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
