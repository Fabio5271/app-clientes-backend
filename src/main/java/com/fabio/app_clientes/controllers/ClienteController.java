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

import com.fabio.app_clientes.models.ClienteDTO;
import com.fabio.app_clientes.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        return new ResponseEntity<>(
            clienteService.getAllClientes(), HttpStatus.OK);
    }

    @GetMapping(path = "/{clienteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable Long clienteId) {
        ClienteDTO clienteDTO = clienteService.getClienteById(clienteId);
        if (clienteDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
    }
    
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO newClienteDTO = clienteService.saveCliente(clienteDTO);
        return new ResponseEntity<>(newClienteDTO, HttpStatus.CREATED);
    }
    
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> updateCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO updClienteDTO = clienteService.saveCliente(clienteDTO);
        return new ResponseEntity<>(updClienteDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{clienteId}")
    public ResponseEntity<Object> deleteCliente(@PathVariable Long clienteId) {
        clienteService.deleteCliente(clienteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
