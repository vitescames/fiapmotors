package br.com.fiap.fiapmotors.core.port.in;

import br.com.fiap.fiapmotors.core.command.EditarVeiculoCommand;
import br.com.fiap.fiapmotors.core.domain.Veiculo;

public interface EditarVeiculoUseCasePort {
    Veiculo editar(String id, EditarVeiculoCommand editarVeiculoCommand);
}
