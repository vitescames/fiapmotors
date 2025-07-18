package br.com.fiap.fiapmotors.core.port.in;

import br.com.fiap.fiapmotors.core.command.ComprarVeiculoCommand;

public interface ComprarVeiculoUseCasePort {
    void comprar(String id, ComprarVeiculoCommand comprarVeiculoRequest);
}
