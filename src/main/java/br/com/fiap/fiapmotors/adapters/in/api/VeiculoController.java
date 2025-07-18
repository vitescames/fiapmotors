package br.com.fiap.fiapmotors.adapters.in.api;

import br.com.fiap.fiapmotors.adapters.in.api.mapper.VeiculoMapper;
import br.com.fiap.fiapmotors.adapters.in.api.request.ComprarVeiculoRequest;
import br.com.fiap.fiapmotors.adapters.in.api.request.CriarVeiculoRequest;
import br.com.fiap.fiapmotors.adapters.in.api.request.EditarVeiculoRequest;
import br.com.fiap.fiapmotors.adapters.in.api.response.CriarVeiculoResponse;
import br.com.fiap.fiapmotors.adapters.in.api.response.EditarVeiculoResponse;
import br.com.fiap.fiapmotors.adapters.in.api.response.BuscarVeiculoResponse;
import br.com.fiap.fiapmotors.core.command.CriarVeiculoCommand;
import br.com.fiap.fiapmotors.core.command.EditarVeiculoCommand;
import br.com.fiap.fiapmotors.core.domain.Veiculo;
import br.com.fiap.fiapmotors.core.port.in.ComprarVeiculoUseCasePort;
import br.com.fiap.fiapmotors.core.port.in.CriarVeiculoUseCasePort;
import br.com.fiap.fiapmotors.core.port.in.EditarVeiculoUseCasePort;
import br.com.fiap.fiapmotors.core.port.in.ListarVeiculosUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
@RequiredArgsConstructor
public class VeiculoController {

    private final CriarVeiculoUseCasePort criarVeiculoUseCasePort;

    private final EditarVeiculoUseCasePort editarVeiculoUseCasePort;

    private final ListarVeiculosUseCasePort listarVeiculosUseCasePort;

    private final ComprarVeiculoUseCasePort comprarVeiculoUseCasePort;

    private final VeiculoMapper veiculoMapper;

    @PostMapping
    public ResponseEntity<CriarVeiculoResponse> criarVeiculo(@RequestBody CriarVeiculoRequest criarVeiculoRequest) {
        CriarVeiculoCommand criarVeiculoCommand = veiculoMapper.toCriarVeiculoCommand(criarVeiculoRequest);

        return ResponseEntity.status(201).body(veiculoMapper.toCriarVeiculoResponse(criarVeiculoUseCasePort.criar(criarVeiculoCommand)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EditarVeiculoResponse> editarVeiculo(@PathVariable Long id, @RequestBody EditarVeiculoRequest editarVeiculoRequest) {
        EditarVeiculoCommand editarVeiculoCommand = veiculoMapper.toEditarVeiculoCommand(editarVeiculoRequest);

        return ResponseEntity.ok(veiculoMapper.toEditarVeiculoResponse(editarVeiculoUseCasePort.editar(editarVeiculoCommand)));
    }

    @GetMapping
    public ResponseEntity<List<BuscarVeiculoResponse>> listarVeiculos(@RequestParam(required = false) String status) {
        List<Veiculo> veiculos = listarVeiculosUseCasePort.listar(status);

        return ResponseEntity.ok(veiculoMapper.toBuscarVeiculoResponse(veiculos));
    }

    @PostMapping("/{id}/comprar")
    public ResponseEntity<Void> comprarVeiculo(@PathVariable String id, @RequestBody ComprarVeiculoRequest comprarVeiculoRequest) {
        comprarVeiculoUseCasePort.comprar(id, veiculoMapper.toComprarVeiculoCommand(comprarVeiculoRequest));

        return ResponseEntity.noContent().build();
    }
}
