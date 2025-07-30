package br.com.fiap.fiapmotors.adapters.in.api;

import br.com.fiap.fiapmotors.adapters.in.api.mapper.ClienteMapper;
import br.com.fiap.fiapmotors.adapters.in.api.request.CriarClienteRequest;
import br.com.fiap.fiapmotors.adapters.in.api.response.CriarClienteResponse;
import br.com.fiap.fiapmotors.core.command.CriarClienteCommand;
import br.com.fiap.fiapmotors.core.port.in.CriarClienteUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final CriarClienteUseCasePort criarClienteUseCasePort;

    private final ClienteMapper clienteMapper;

    @PostMapping
    public ResponseEntity<CriarClienteResponse> criarCliente(@RequestBody CriarClienteRequest criarClienteRequest) {
        CriarClienteCommand criarClienteCommand = clienteMapper.toCriarClienteCommand(criarClienteRequest);

        return ResponseEntity.status(201).body(clienteMapper.toCriarClienteResponse(criarClienteUseCasePort.criar(criarClienteCommand)));
    }
}
