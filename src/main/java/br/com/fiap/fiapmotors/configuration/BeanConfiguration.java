package br.com.fiap.fiapmotors.configuration;

import br.com.fiap.fiapmotors.core.port.in.*;
import br.com.fiap.fiapmotors.core.port.out.ClienteRepositoryPort;
import br.com.fiap.fiapmotors.core.port.out.VeiculoRepositoryPort;
import br.com.fiap.fiapmotors.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ComprarVeiculoUseCasePort comprarVeiculoUseCasePort(VeiculoRepositoryPort veiculoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort) {
        return new ComprarVeiculoUseCase(veiculoRepositoryPort, clienteRepositoryPort);
    }

    @Bean
    CriarClienteUseCasePort criarClienteUseCasePort(ClienteRepositoryPort clienteRepositoryPort) {
        return new CriarClienteUseCase(clienteRepositoryPort);
    }

    @Bean
    CriarVeiculoUseCasePort criarVeiculoUseCasePort(VeiculoRepositoryPort veiculoRepositoryPort) {
        return new CriarVeiculoUseCase(veiculoRepositoryPort);
    }

    @Bean
    EditarVeiculoUseCasePort editarVeiculoUseCasePort(VeiculoRepositoryPort veiculoRepositoryPort) {
        return new EditarVeiculoUseCase(veiculoRepositoryPort);
    }

    @Bean
    ListarVeiculosUseCasePort listarVeiculosUseCasePort(VeiculoRepositoryPort veiculoRepositoryPort) {
        return new ListarVeiculosUseCase(veiculoRepositoryPort);
    }
}
