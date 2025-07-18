package br.com.fiap.fiapmotors.core.port.in;

import br.com.fiap.fiapmotors.core.command.CriarVeiculoCommand;
import br.com.fiap.fiapmotors.core.domain.Veiculo;

public interface CriarVeiculoUseCasePort {
    Veiculo criar(CriarVeiculoCommand criarVeiculoCommand);
}
