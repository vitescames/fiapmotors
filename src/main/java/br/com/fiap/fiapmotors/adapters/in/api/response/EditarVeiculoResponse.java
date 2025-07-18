package br.com.fiap.fiapmotors.adapters.in.api.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EditarVeiculoResponse {

    private String id;

    private String tipo;

    private String marca;

    private String ano;

    private String cor;

    private BigDecimal preco;
}
