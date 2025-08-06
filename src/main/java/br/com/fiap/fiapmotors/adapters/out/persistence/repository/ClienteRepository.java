package br.com.fiap.fiapmotors.adapters.out.persistence.repository;

import br.com.fiap.fiapmotors.adapters.out.persistence.jpa.ClienteRepositoryJPA;
import br.com.fiap.fiapmotors.adapters.out.persistence.orm.ClienteEntity;
import br.com.fiap.fiapmotors.core.domain.Cliente;
import br.com.fiap.fiapmotors.core.port.out.ClienteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteRepository implements ClienteRepositoryPort {

    private final ClienteRepositoryJPA clienteRepositoryJPA;

    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setSexo(cliente.getSexo());
        clienteEntity.setCpf(cliente.getCpf());
        clienteEntity.setIdade(cliente.getIdade());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setId(cliente.getId());

        ClienteEntity clienteSalvo = clienteRepositoryJPA.save(clienteEntity);

        cliente.setId(clienteSalvo.getId());

        return cliente;
    }

    @Override
    public Cliente buscarPorId(String id) {
        Optional<ClienteEntity> clienteEntityOptional = clienteRepositoryJPA.findById(id);

        return clienteEntityOptional.map(clienteEntity -> {
                    Cliente cliente = new Cliente();

                    cliente.setNome(clienteEntity.getNome());
                    cliente.setSexo(clienteEntity.getSexo());
                    cliente.setCpf(clienteEntity.getCpf());
                    cliente.setIdade(clienteEntity.getIdade());
                    cliente.setId(clienteEntity.getId());
                    cliente.setEmail(clienteEntity.getEmail());

                    return cliente;
                })
                .orElse(null);
    }
}
