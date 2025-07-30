package br.com.fiap.fiapmotors.adapters.out.persistence.jpa;

import br.com.fiap.fiapmotors.adapters.out.persistence.orm.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepositoryJPA extends JpaRepository<VeiculoEntity, String> {
    List<VeiculoEntity> findByClienteIsNotNullOrderByPrecoAsc();
    List<VeiculoEntity> findByClienteIsNullOrderByPrecoAsc();
}
