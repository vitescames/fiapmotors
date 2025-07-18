package br.com.fiap.fiapmotors.adapters.in.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarClienteRequest {

    private String nome;

    private Integer idade;

    private String sexo;

    private String cpf;
}
