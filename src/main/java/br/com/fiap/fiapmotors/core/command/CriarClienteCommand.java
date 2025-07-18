package br.com.fiap.fiapmotors.core.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CriarClienteCommand {

    private String nome;

    private Integer idade;

    private String sexo;

    private String cpf;
}
