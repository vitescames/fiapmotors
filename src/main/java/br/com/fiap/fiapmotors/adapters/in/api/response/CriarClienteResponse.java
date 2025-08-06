package br.com.fiap.fiapmotors.adapters.in.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarClienteResponse {

    private String id;

    private String nome;

    private Integer idade;

    private String sexo;

    private String cpf;

    private String email;
}
