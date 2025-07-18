package br.com.fiap.fiapmotors.core.port.in;

import br.com.fiap.fiapmotors.core.command.CriarClienteCommand;
import br.com.fiap.fiapmotors.core.domain.Cliente;

public interface CriarClienteUseCasePort {
    Cliente criar(CriarClienteCommand criarClienteCommand);
}
