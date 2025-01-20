package com.fabio.app_clientes.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    
    @NotBlank(message = "Forneça o nome")
    @Size(min = 3, max = 100, message = "Nome tem que ter entre 3 e 100 caracteres")
    @Pattern(regexp = "^[\\p{L}\\p{N} ]*$", message = "Nome tem que ter apenas letras, espaços e números")
    private String nome;

    @NotBlank(message = "Forneça o cpf")
    private String cpf;

    @NotBlank(message = "Forneça o cep")
    private String cep;

    @NotBlank(message = "Forneça o logradouro")
    private String logradouro;

    @NotBlank(message = "Forneça o bairro")
    private String bairro;

    @NotBlank(message = "Forneça a cidade")
    private String cidade;

    @NotBlank(message = "Forneça a uf")
    private String uf;

    private String complEndrc;
}
