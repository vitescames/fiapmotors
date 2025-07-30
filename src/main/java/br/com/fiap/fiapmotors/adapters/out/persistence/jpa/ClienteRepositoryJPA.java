package br.com.fiap.fiapmotors.adapters.out.persistence.jpa;

import br.com.fiap.fiapmotors.adapters.out.persistence.orm.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositoryJPA extends JpaRepository<ClienteEntity, String> {
}
