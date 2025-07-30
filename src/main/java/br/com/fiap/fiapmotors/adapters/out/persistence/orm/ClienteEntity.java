package br.com.fiap.fiapmotors.adapters.out.persistence.orm;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "cliente")
@Data
public class ClienteEntity {

    @Id
    private String id;

    private String nome;

    private Integer idade;

    private String sexo;

    private String cpf;

    @PrePersist
    private void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
