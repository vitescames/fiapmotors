package br.com.fiap.fiapmotors.core.port.out;

import br.com.fiap.fiapmotors.core.domain.Veiculo;

import java.util.List;

public interface VeiculoRepositoryPort {
    Veiculo salvar(Veiculo veiculo);

    Veiculo buscarPorId(String id);

    List<Veiculo> buscarPorStatus(String status);

    void comprar(String idVeiculo, String idCliente);
}
