package br.com.fiap.fiapmotors.adapters.in.api.mapper;

import br.com.fiap.fiapmotors.adapters.in.api.request.CriarClienteRequest;
import br.com.fiap.fiapmotors.adapters.in.api.response.CriarClienteResponse;
import br.com.fiap.fiapmotors.core.command.CriarClienteCommand;
import br.com.fiap.fiapmotors.core.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public CriarClienteCommand toCriarClienteCommand(CriarClienteRequest criarClienteRequest) {
        CriarClienteCommand criarClienteCommand = new CriarClienteCommand();

        criarClienteCommand.setCpf(criarClienteRequest.getCpf());
        criarClienteCommand.setNome(criarClienteRequest.getNome());
        criarClienteCommand.setSexo(criarClienteRequest.getSexo());
        criarClienteCommand.setIdade(criarClienteRequest.getIdade());

        return criarClienteCommand;
    }

    public CriarClienteResponse toCriarClienteResponse(Cliente cliente) {
        CriarClienteResponse criarClienteResponse = new CriarClienteResponse();

        criarClienteResponse.setIdade(cliente.getIdade());
        criarClienteResponse.setCpf(cliente.getCpf());
        criarClienteResponse.setSexo(cliente.getSexo());
        criarClienteResponse.setNome(cliente.getNome());
        criarClienteResponse.setId(cliente.getId());

        return criarClienteResponse;
    }
}
