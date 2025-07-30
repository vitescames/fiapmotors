package br.com.fiap.fiapmotors.core.usecase;

import br.com.fiap.fiapmotors.core.domain.Veiculo;
import br.com.fiap.fiapmotors.core.port.in.ListarVeiculosUseCasePort;
import br.com.fiap.fiapmotors.core.port.out.VeiculoRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListarVeiculosUseCase implements ListarVeiculosUseCasePort {

    private final VeiculoRepositoryPort veiculoRepositoryPort;

    @Override
    public List<Veiculo> listar(String status) {
        return veiculoRepositoryPort.buscarPorStatus(status);
    }
}
