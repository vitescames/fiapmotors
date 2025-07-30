package br.com.fiap.fiapmotors.core.usecase;

import br.com.fiap.fiapmotors.core.command.CriarVeiculoCommand;
import br.com.fiap.fiapmotors.core.domain.Veiculo;
import br.com.fiap.fiapmotors.core.port.in.CriarVeiculoUseCasePort;
import br.com.fiap.fiapmotors.core.port.out.VeiculoRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarVeiculoUseCase implements CriarVeiculoUseCasePort {

    private final VeiculoRepositoryPort veiculoRepositoryPort;

    @Override
    public Veiculo criar(CriarVeiculoCommand criarVeiculoCommand) {
        Veiculo veiculo = new Veiculo();

        veiculo.setAno(criarVeiculoCommand.getAno());
        veiculo.setCor(criarVeiculoCommand.getCor());
        veiculo.setMarca(criarVeiculoCommand.getMarca());
        veiculo.setTipo(criarVeiculoCommand.getTipo());
        veiculo.setPreco(criarVeiculoCommand.getPreco());

        return veiculoRepositoryPort.salvar(veiculo);
    }
}
