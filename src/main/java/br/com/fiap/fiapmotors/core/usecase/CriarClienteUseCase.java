package br.com.fiap.fiapmotors.core.usecase;

import br.com.fiap.fiapmotors.core.command.CriarClienteCommand;
import br.com.fiap.fiapmotors.core.domain.Cliente;
import br.com.fiap.fiapmotors.core.port.in.CriarClienteUseCasePort;
import br.com.fiap.fiapmotors.core.port.out.ClienteRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarClienteUseCase implements CriarClienteUseCasePort {

    private final ClienteRepositoryPort clienteRepositoryPort;

    @Override
    public Cliente criar(CriarClienteCommand criarClienteCommand) {
        Cliente cliente = new Cliente();

        cliente.setCpf(criarClienteCommand.getCpf());
        cliente.setIdade(criarClienteCommand.getIdade());
        cliente.setNome(criarClienteCommand.getNome());
        cliente.setSexo(criarClienteCommand.getSexo());

        return clienteRepositoryPort.salvar(cliente);
    }
}
