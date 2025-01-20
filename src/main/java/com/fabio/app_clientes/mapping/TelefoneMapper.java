package com.fabio.app_clientes.mapping;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fabio.app_clientes.entities.Telefone;
import com.fabio.app_clientes.models.TelefoneDTO;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {
    TelefoneMapper INSTANCE = Mappers.getMapper(TelefoneMapper.class);
    TelefoneDTO convert(Telefone telefone);
    Telefone convert(TelefoneDTO telefoneDTO);
    List<TelefoneDTO> convertList(List<Telefone> telefones);
}
