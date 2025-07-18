package br.com.fiap.fiapmotors.adapters.in.api.mapper;

import br.com.fiap.fiapmotors.adapters.in.api.request.ComprarVeiculoRequest;
import br.com.fiap.fiapmotors.adapters.in.api.request.CriarVeiculoRequest;
import br.com.fiap.fiapmotors.adapters.in.api.request.EditarVeiculoRequest;
import br.com.fiap.fiapmotors.adapters.in.api.response.BuscarVeiculoResponse;
import br.com.fiap.fiapmotors.adapters.in.api.response.CriarVeiculoResponse;
import br.com.fiap.fiapmotors.adapters.in.api.response.EditarVeiculoResponse;
import br.com.fiap.fiapmotors.core.command.ComprarVeiculoCommand;
import br.com.fiap.fiapmotors.core.command.CriarVeiculoCommand;
import br.com.fiap.fiapmotors.core.command.EditarVeiculoCommand;
import br.com.fiap.fiapmotors.core.domain.Veiculo;

import java.util.List;

public class VeiculoMapper {
    public CriarVeiculoCommand toCriarVeiculoCommand(CriarVeiculoRequest criarVeiculoRequest) {
        CriarVeiculoCommand criarVeiculoCommand = new CriarVeiculoCommand();

        criarVeiculoCommand.setAno(criarVeiculoRequest.getAno());
        criarVeiculoCommand.setTipo(criarVeiculoRequest.getTipo());
        criarVeiculoCommand.setCor(criarVeiculoRequest.getCor());
        criarVeiculoCommand.setPreco(criarVeiculoRequest.getPreco());
        criarVeiculoCommand.setMarca(criarVeiculoRequest.getMarca());

        return criarVeiculoCommand;
    }

    public CriarVeiculoResponse toCriarVeiculoResponse(Veiculo veiculo) {
        CriarVeiculoResponse criarVeiculoResponse = new CriarVeiculoResponse();

        criarVeiculoResponse.setAno(veiculo.getAno());
        criarVeiculoResponse.setTipo(veiculo.getTipo());
        criarVeiculoResponse.setPreco(veiculo.getPreco());
        criarVeiculoResponse.setMarca(veiculo.getMarca());
        criarVeiculoResponse.setCor(veiculo.getCor());
        criarVeiculoResponse.setId(veiculo.getId());

        return criarVeiculoResponse;
    }

    public EditarVeiculoCommand toEditarVeiculoCommand(EditarVeiculoRequest editarVeiculoRequest) {
        EditarVeiculoCommand editarVeiculoCommand = new EditarVeiculoCommand();

        editarVeiculoCommand.setAno(editarVeiculoRequest.getAno());
        editarVeiculoCommand.setCor(editarVeiculoRequest.getCor());
        editarVeiculoCommand.setMarca(editarVeiculoRequest.getMarca());
        editarVeiculoCommand.setTipo(editarVeiculoRequest.getTipo());
        editarVeiculoCommand.setPreco(editarVeiculoRequest.getPreco());

        return editarVeiculoCommand;
    }

    public EditarVeiculoResponse toEditarVeiculoResponse(Veiculo veiculo) {
        EditarVeiculoResponse editarVeiculoResponse = new EditarVeiculoResponse();

        editarVeiculoResponse.setAno(veiculo.getAno());
        editarVeiculoResponse.setCor(veiculo.getCor());
        editarVeiculoResponse.setTipo(veiculo.getTipo());
        editarVeiculoResponse.setId(veiculo.getId());
        editarVeiculoResponse.setMarca(veiculo.getMarca());
        editarVeiculoResponse.setPreco(veiculo.getPreco());

        return editarVeiculoResponse;
    }

    public List<BuscarVeiculoResponse> toBuscarVeiculoResponse(List<Veiculo> veiculos) {
        return veiculos.stream().map(veiculo -> {
            BuscarVeiculoResponse buscarVeiculoResponse = new BuscarVeiculoResponse();

            buscarVeiculoResponse.setAno(veiculo.getAno());
            buscarVeiculoResponse.setCor(veiculo.getCor());
            buscarVeiculoResponse.setTipo(veiculo.getTipo());
            buscarVeiculoResponse.setMarca(veiculo.getMarca());
            buscarVeiculoResponse.setId(veiculo.getId());
            buscarVeiculoResponse.setCliente(veiculo.getCliente());
            buscarVeiculoResponse.setPreco(veiculo.getPreco());

            return buscarVeiculoResponse;
        }).toList();
    }

    public ComprarVeiculoCommand toComprarVeiculoCommand(ComprarVeiculoRequest comprarVeiculoRequest) {
        ComprarVeiculoCommand command = new ComprarVeiculoCommand();

        command.setCliente(comprarVeiculoRequest.getCliente());

        return command;
    }
}
