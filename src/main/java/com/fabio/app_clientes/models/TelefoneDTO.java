package com.fabio.app_clientes.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TelefoneDTO {
    private Long id;
    
    @NotBlank(message = "Forneça o id do cliente")
    private Long idCliente;

    @NotBlank(message = "Forneça o número do telefone")
    private String numero;

    @NotBlank(message = "Forneça o tipo do telefone")
    private String tipo;
}
