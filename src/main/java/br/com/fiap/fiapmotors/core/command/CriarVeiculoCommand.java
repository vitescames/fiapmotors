package br.com.fiap.fiapmotors.core.command;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CriarVeiculoCommand {

    private String tipo;

    private String marca;

    private String ano;

    private String cor;

    private BigDecimal preco;
}
