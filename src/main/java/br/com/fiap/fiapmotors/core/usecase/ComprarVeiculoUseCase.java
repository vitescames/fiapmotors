package br.com.fiap.fiapmotors.core.usecase;

import br.com.fiap.fiapmotors.core.command.ComprarVeiculoCommand;
import br.com.fiap.fiapmotors.core.domain.Cliente;
import br.com.fiap.fiapmotors.core.domain.Veiculo;
import br.com.fiap.fiapmotors.core.port.in.ComprarVeiculoUseCasePort;
import br.com.fiap.fiapmotors.core.port.out.ClienteRepositoryPort;
import br.com.fiap.fiapmotors.core.port.out.VeiculoRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ComprarVeiculoUseCase implements ComprarVeiculoUseCasePort {

    private final VeiculoRepositoryPort veiculoRepositoryPort;

    private final ClienteRepositoryPort clienteRepositoryPort;

    @Override
    public void comprar(String id, ComprarVeiculoCommand comprarVeiculoRequest) {
        Cliente clienteComprador = clienteRepositoryPort.buscarPorId(comprarVeiculoRequest.getCliente());

        if (clienteComprador == null)
            throw new RuntimeException(String.format("O cliente de ID %s não existe", comprarVeiculoRequest.getCliente()));

        Veiculo veiculo = veiculoRepositoryPort.buscarPorId(id);

        if (veiculo == null)
            throw new RuntimeException(String.format("O veículo de ID %s não existe", id));

        veiculoRepositoryPort.comprar(id, comprarVeiculoRequest.getCliente());
    }
}
