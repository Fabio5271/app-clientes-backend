package com.fabio.app_clientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.app_clientes.entities.Cliente;
import com.fabio.app_clientes.mapping.ClienteMapper;
import com.fabio.app_clientes.models.ClienteDTO;
import com.fabio.app_clientes.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public List<ClienteDTO> getAllClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.convertList(clientes);
    }

    public ClienteDTO getClienteById(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(clienteMapper::convert).orElse(null);
    }

    public ClienteDTO saveCliente(ClienteDTO clienteDTO){
        Cliente clienteE = clienteMapper.convert(clienteDTO);
        Cliente cliente = clienteRepository.save(clienteE);
        return clienteMapper.convert(cliente);
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
