package br.com.fiap.fiapmotors.core.port.in;

import br.com.fiap.fiapmotors.core.domain.Veiculo;

import java.util.List;

public interface ListarVeiculosUseCasePort {
    List<Veiculo> listar(String status);
}
