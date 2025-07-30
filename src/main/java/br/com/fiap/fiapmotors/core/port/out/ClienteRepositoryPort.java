package br.com.fiap.fiapmotors.core.port.out;

import br.com.fiap.fiapmotors.core.domain.Cliente;

public interface ClienteRepositoryPort {
    Cliente salvar(Cliente cliente);

    Cliente buscarPorId(String id);
}
