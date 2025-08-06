package br.com.fiap.fiapmotors.configuration;

import br.com.fiap.fiapmotors.core.port.in.*;
import br.com.fiap.fiapmotors.core.port.out.ClienteIdentityPort;
import br.com.fiap.fiapmotors.core.port.out.ClienteRepositoryPort;
import br.com.fiap.fiapmotors.core.port.out.VeiculoRepositoryPort;
import br.com.fiap.fiapmotors.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;

@Configuration
public class BeanConfiguration {

    @Bean
    ComprarVeiculoUseCasePort comprarVeiculoUseCasePort(VeiculoRepositoryPort veiculoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort) {
        return new ComprarVeiculoUseCase(veiculoRepositoryPort, clienteRepositoryPort);
    }

    @Bean
    CriarClienteUseCasePort criarClienteUseCasePort(ClienteRepositoryPort clienteRepositoryPort, ClienteIdentityPort clienteIdentityPort) {
        return new CriarClienteUseCase(clienteRepositoryPort, clienteIdentityPort);
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

    @Bean
    public CognitoIdentityProviderClient cognitoClient() {
        return CognitoIdentityProviderClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }
}
