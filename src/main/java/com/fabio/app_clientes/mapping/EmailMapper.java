package com.fabio.app_clientes.mapping;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fabio.app_clientes.entities.Email;
import com.fabio.app_clientes.models.EmailDTO;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);
    EmailDTO convert(Email email);
    Email convert(EmailDTO emailDTO);
    List<EmailDTO> convertList(List<Email> emails);
}
