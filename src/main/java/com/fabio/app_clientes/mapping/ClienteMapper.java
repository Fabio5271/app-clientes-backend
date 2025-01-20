package com.fabio.app_clientes.mapping;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fabio.app_clientes.entities.Cliente;
import com.fabio.app_clientes.models.ClienteDTO;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
    ClienteDTO convert(Cliente cliente);
    Cliente convert(ClienteDTO clienteDTO);
    List<ClienteDTO> convertList(List<Cliente> clientes);
}
