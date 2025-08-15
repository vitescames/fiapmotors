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

        setIfNotNull(editarVeiculoCommand.getAno(),   veiculo::setAno);
        setIfNotNull(editarVeiculoCommand.getCor(),   veiculo::setCor);
        setIfNotNull(editarVeiculoCommand.getMarca(), veiculo::setMarca);
        setIfNotNull(editarVeiculoCommand.getTipo(),  veiculo::setTipo);
        setIfNotNull(editarVeiculoCommand.getPreco(), veiculo::setPreco);

        return veiculoRepositoryPort.salvar(veiculo);
    }

    private static <T> void setIfNotNull(T value, java.util.function.Consumer<T> setter) {
        if (value != null) setter.accept(value);
    }
}
