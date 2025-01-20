package com.fabio.app_clientes.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {
    private Long id;

    @NotBlank(message = "Forneça o id do cliente")
    private Long idCliente;

    @NotBlank(message = "Forneça o endereço de email")
    @Email(message = "Endereço de email inválido")
    private String endereco;
}
