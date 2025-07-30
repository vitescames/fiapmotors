package br.com.fiap.fiapmotors.core.usecase;

import br.com.fiap.fiapmotors.core.command.EditarVeiculoCommand;
import br.com.fiap.fiapmotors.core.domain.Veiculo;
import br.com.fiap.fiapmotors.core.port.in.EditarVeiculoUseCasePort;
import br.com.fiap.fiapmotors.core.port.out.VeiculoRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditarVeiculoUseCase implements EditarVeiculoUseCasePort {

    private final VeiculoRepositoryPort veiculoRepositoryPort;

    @Override
    public Veiculo editar(String id, EditarVeiculoCommand editarVeiculoCommand) {
        Veiculo veiculo = veiculoRepositoryPort.buscarPorId(id);

        if (veiculo == null)
            throw new RuntimeException(String.format("O veículo de ID %s não existe", id));

        veiculo.setAno(editarVeiculoCommand.getAno());
        veiculo.setCor(editarVeiculoCommand.getCor());
        veiculo.setMarca(editarVeiculoCommand.getMarca());
        veiculo.setTipo(editarVeiculoCommand.getTipo());
        veiculo.setPreco(editarVeiculoCommand.getPreco());

        return veiculoRepositoryPort.salvar(veiculo);
    }
}
