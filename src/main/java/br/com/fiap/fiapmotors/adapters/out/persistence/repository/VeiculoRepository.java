package br.com.fiap.fiapmotors.adapters.out.persistence.repository;

import br.com.fiap.fiapmotors.adapters.out.persistence.jpa.VeiculoRepositoryJPA;
import br.com.fiap.fiapmotors.adapters.out.persistence.orm.VeiculoEntity;
import br.com.fiap.fiapmotors.core.domain.Veiculo;
import br.com.fiap.fiapmotors.core.port.out.VeiculoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeiculoRepository implements VeiculoRepositoryPort {

    private final VeiculoRepositoryJPA veiculoRepositoryJPA;

    @Override
    public Veiculo salvar(Veiculo veiculo) {
        VeiculoEntity veiculoEntity = new VeiculoEntity();

        if (veiculo.getId() != null) {
            veiculoEntity.setId(veiculo.getId());
        }

        veiculoEntity.setTipo(veiculo.getTipo());
        veiculoEntity.setCor(veiculo.getCor());
        veiculoEntity.setMarca(veiculo.getMarca());
        veiculoEntity.setPreco(veiculo.getPreco());
        veiculoEntity.setAno(veiculo.getAno());

        VeiculoEntity veiculoSalvo = veiculoRepositoryJPA.save(veiculoEntity);

        veiculo.setId(veiculoSalvo.getId());

        return veiculo;
    }

    @Override
    public Veiculo buscarPorId(String id) {
        Optional<VeiculoEntity> veiculoEntityOptional = veiculoRepositoryJPA.findById(id);

        return veiculoEntityOptional.map(veiculoEntity -> {
            Veiculo veiculo = new Veiculo();

            veiculo.setPreco(veiculoEntity.getPreco());
            veiculo.setTipo(veiculoEntity.getTipo());
            veiculo.setAno(veiculoEntity.getAno());
            veiculo.setCor(veiculoEntity.getCor());
            veiculo.setMarca(veiculoEntity.getMarca());
            veiculo.setId(veiculoEntity.getId());
            veiculo.setCliente(veiculoEntity.getCliente());

            return veiculo;
        }).orElse(null);
    }

    @Override
    public List<Veiculo> buscarPorStatus(String status) {
        List<VeiculoEntity> veiculos;

        if ("vendidos".equals(status)) {
            veiculos = veiculoRepositoryJPA.findByClienteIsNotNullOrderByPrecoAsc();
        } else {
            veiculos = veiculoRepositoryJPA.findByClienteIsNullOrderByPrecoAsc();
        }

        return veiculos.stream().map(veiculoEntity -> {
            Veiculo veiculo = new Veiculo();

            veiculo.setPreco(veiculoEntity.getPreco());
            veiculo.setTipo(veiculoEntity.getTipo());
            veiculo.setAno(veiculoEntity.getAno());
            veiculo.setCor(veiculoEntity.getCor());
            veiculo.setMarca(veiculoEntity.getMarca());
            veiculo.setId(veiculoEntity.getId());
            veiculo.setCliente(veiculoEntity.getCliente());

            return veiculo;
        }).toList();
    }

    @Override
    public void comprar(String idVeiculo, String idCliente) {
        Optional<VeiculoEntity> veiculoEntityOptional = veiculoRepositoryJPA.findById(idVeiculo);

        veiculoEntityOptional.ifPresent(veiculoEntity -> {
            veiculoEntity.setCliente(idCliente);
            veiculoRepositoryJPA.save(veiculoEntity);
        });
    }
}
