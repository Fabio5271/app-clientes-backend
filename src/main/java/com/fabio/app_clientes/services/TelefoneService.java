package com.fabio.app_clientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.app_clientes.entities.Telefone;
import com.fabio.app_clientes.mapping.TelefoneMapper;
import com.fabio.app_clientes.models.TelefoneDTO;
import com.fabio.app_clientes.repositories.TelefoneRepository;

@Service
public class TelefoneService {
    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private TelefoneMapper telefoneMapper;

    public List<TelefoneDTO> getAllTelefones(){
        List<Telefone> telefones = telefoneRepository.findAll();
        return telefoneMapper.convertList(telefones);
    }

    public TelefoneDTO getTelefoneById(Long id){
        Optional<Telefone> telefone = telefoneRepository.findById(id);
        return telefone.map(telefoneMapper::convert).orElse(null);
    }

    public TelefoneDTO saveTelefone (TelefoneDTO telefoneDTO){
        Telefone telefoneE = telefoneMapper.convert(telefoneDTO);
        Telefone telefone = telefoneRepository.save(telefoneE);
        return telefoneMapper.convert(telefone);
    }

    public void deleteTelefone(Long id){
        telefoneRepository.deleteById(id);
    }
}
